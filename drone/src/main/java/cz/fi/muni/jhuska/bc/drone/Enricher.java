package cz.fi.muni.jhuska.bc.drone;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.test.spi.TestEnricher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.Factory;

public class Enricher implements TestEnricher {

	private static final String COMPONENT_ANNOTATION = "org.openqa.selenium.support.FindBy";

	@Override
	public void enrich(Object testCase) {
		if (ReflectionHelper.isClassPresent(COMPONENT_ANNOTATION)) {

			// gets all fields and then removes these which does not extend
			// particular class according to component contract
			List<Field> fields = ReflectionHelper.getFieldsWithAnnotation(
					testCase.getClass(), FindBy.class);
			fields = removeNotFindByComponents(fields);

			for (Field componentField : fields) {

				// initialise component
				Class implementationClass = componentField.getType();
				Object component = Factory
						.initializeComponent(implementationClass);

				// sets the root of the component, retrieved from annotation
				FindBy findBy = componentField.getAnnotation(FindBy.class);
				final By by = Factory.getReferencedBy(findBy);

				WebElement rootElement = (WebElement) Proxy.newProxyInstance(
						WebElement.class.getClassLoader(),
						new Class<?>[] { WebElement.class },
						new InvocationHandler() {

							@Override
							public Object invoke(Object proxy, Method method,
									Object[] args) throws Throwable {
								
								WebDriver driver = GrapheneContext.getProxy();
								WebElement root =  driver.findElement(by);
								
								return (Object) method.invoke(root, args);
							}
						});
				
				((AbstractComponent) component).setRoot(rootElement); 

				// sets the component to the test class object
				boolean accessible = componentField.isAccessible();
				if (!accessible) {
					componentField.setAccessible(true);
				}
				try {
					componentField.set(testCase, component);
				} catch (Exception e) {
					// TODO more grained
					throw new RuntimeException(
							"The components fields can not be initialised!");
				}
				if (!accessible) {
					componentField.setAccessible(false);
				}
			}
		}
	}

	/**
	 * It removes all components from given list which does not extend the
	 * <code>cz.fi.muni.jhuska.bc.api.AbstractComponent</code>
	 * 
	 * @param findByFields
	 * @return
	 */
	private List<Field> removeNotFindByComponents(List<Field> findByFields) {

		for (Iterator<Field> i = findByFields.iterator(); i.hasNext();) {

			try {
				Field field = i.next();

				Class clazz = Class.forName(field.getGenericType().toString()
						.split(" ")[1]);

				String superClass = null;
				try {
					superClass = (clazz.getGenericSuperclass().toString()
							.split(" ")[1]);
				} catch (NullPointerException ex) {
					// it is ok in some cases, lets continue with other elements
				}

				if (superClass == null
						|| !superClass
								.equals("cz.fi.muni.jhuska.bc.api.AbstractComponent")) {

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
