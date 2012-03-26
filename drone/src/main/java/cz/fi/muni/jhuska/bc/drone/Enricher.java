package cz.fi.muni.jhuska.bc.drone;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.spi.TestEnricher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.annotations.Component;
import cz.fi.muni.jhuska.bc.api.AbstractComponent;
import cz.fi.muni.jhuska.bc.api.Factory;

public class Enricher implements TestEnricher {

	private static final String COMPONENT_ANNOTATION = "cz.fi.muni.jhuska.bc.annotations.Component";

	@Override
	public void enrich(Object testCase) {
		if (ReflectionHelper.isClassPresent(COMPONENT_ANNOTATION)) {

			List<Field> fields = ReflectionHelper.getFieldsWithAnnotation(
					testCase.getClass(), Component.class);

			for (Field componentField : fields) {

				Class implementationClass = componentField.getType();
				Object component = Factory
						.initializeComponent(implementationClass);

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

	@Override
	public Object[] resolve(Method method) {
		return new Object[method.getParameterTypes().length];
	}

}
