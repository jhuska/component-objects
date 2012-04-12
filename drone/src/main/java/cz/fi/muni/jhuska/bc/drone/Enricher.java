package cz.fi.muni.jhuska.bc.drone;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.test.spi.TestEnricher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import cz.fi.muni.jhuska.bc.annotations.Page;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.AbstractPage;
import cz.fi.muni.jhuska.bc.api.Factory;

public class Enricher implements TestEnricher {

    private static final String FIND_BY_ANNOTATION = "org.openqa.selenium.support.FindBy";
    private static final String PAGE_ANNOTATION = "cz.fi.muni.jhuska.bc.annotations.Page";

    @Override
    public void enrich(Object testCase) {

        // at first initialize findBy annotations
        if (ReflectionHelper.isClassPresent(FIND_BY_ANNOTATION)) {

            initFieldsAnnotatedByFindBy(testCase);
        }
        // initialize Page objects if there are any
        if (ReflectionHelper.isClassPresent(PAGE_ANNOTATION)) {

            List<Field> fields = ReflectionHelper.getFieldsWithAnnotation(testCase.getClass(), Page.class);

            initializePageObjectFields(testCase, fields);
        }
    }

    private void initFieldsAnnotatedByFindBy(Object object) {

        // gets all fields with findBy annotations and then removes these
        // which are not Components objects
        List<Field> fields = ReflectionHelper.getFieldsWithAnnotation(object.getClass(), FindBy.class);

        List<Field> copy = new ArrayList<Field>();
        copy.addAll(fields);

        fields = removePlainFindBy(fields);
        initComponentFields(fields, object);

        // initialize other non component Find By fields
        copy.removeAll(fields);
        initNotComponentFields(copy, object);
    }

    private void initializePageObjectFields(Object testCase, List<Field> fields) {

        for (Field i : fields) {

            try {
                Class declaredClass = Class.forName(i.getGenericType().toString().split(" ")[1]);
                Object page = declaredClass.newInstance();

                List<Field> componentFields = ReflectionHelper.getFieldsWithAnnotation(declaredClass, FindBy.class);

                initFieldsAnnotatedByFindBy(page);

                boolean accessible = i.isAccessible();
                if (!accessible) {
                    i.setAccessible(true);
                }
                i.set(testCase, page);
                if (!accessible) {
                    i.setAccessible(false);
                }
            } catch (Exception ex) {
                throw new RuntimeException("Can not initialise Page Object!");
            }
        }
    }

    private void initNotComponentFields(List<Field> fields, Object object) {

        for (Field i : fields) {

            FindBy findBy = i.getAnnotation(FindBy.class);
            final By by = Factory.getReferencedBy(findBy);

            WebElement element = setUpTheProxy(by);

            setObjectToField(i, object, element);
        }
    }

    private void setObjectToField(Field field, Object objectWithField, Object object) {

        boolean accessible = field.isAccessible();
        if (!accessible) {
            field.setAccessible(true);
        }
        try {
            field.set(objectWithField, object);
        } catch (Exception e) {
            // TODO more grained
            throw new RuntimeException("The components fields can not be initialised!");
        }
        if (!accessible) {
            field.setAccessible(false);
        }
    }

    private WebElement setUpTheProxy(final By by) {

        return (WebElement) Proxy.newProxyInstance(WebElement.class.getClassLoader(), new Class<?>[] { WebElement.class },
            new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    WebDriver driver = GrapheneContext.getProxy();
                    WebElement root = driver.findElement(by);

                    return (Object) method.invoke(root, args);
                }
            });
    }

    private void initComponentFields(List<Field> fields, Object object) {
        for (Field componentField : fields) {

            // initialise component
            Class implementationClass = componentField.getType();
            Object component = Factory.initializeComponent(implementationClass);

            // sets the root of the component, retrieved from annotation
            FindBy findBy = componentField.getAnnotation(FindBy.class);
            final By by = Factory.getReferencedBy(findBy);

            WebElement rootElement = setUpTheProxy(by);
            ((AbstractComponent) component).setRoot(rootElement);

            setObjectToField(componentField, object, component);
        }

    }

    /**
     * It removes all components from given list which does not extend the
     * <code>cz.fi.muni.jhuska.bc.api.AbstractComponent</code>
     * 
     * @param findByFields
     * @return
     */
    private List<Field> removePlainFindBy(List<Field> findByFields) {

        for (Iterator<Field> i = findByFields.iterator(); i.hasNext();) {

            try {
                Field field = i.next();

                Class clazz = Class.forName(field.getGenericType().toString().split(" ")[1]);

                String superClass = null;
                try {
                    superClass = (clazz.getGenericSuperclass().toString().split(" ")[1]);
                } catch (NullPointerException ex) {
                    // it is ok in some cases, lets continue with other elements
                }

                if (superClass == null || !superClass.equals("cz.fi.muni.jhuska.bc.api.AbstractComponent")) {

                    i.remove();
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return findByFields;
    }

    @Override
    public Object[] resolve(Method method) {
        return new Object[method.getParameterTypes().length];
    }

}
