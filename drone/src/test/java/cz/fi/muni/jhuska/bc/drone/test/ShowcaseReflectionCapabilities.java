package cz.fi.muni.jhuska.bc.drone.test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.openqa.selenium.support.FindBy;

import cz.fi.muni.jhuska.bc.annotations.Page;

public class ShowcaseReflectionCapabilities {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Field[] declaredFields = TestGoogleTranslate.class.getDeclaredFields();
		
		for(Field i : declaredFields) {
			String name = i.getName();
			Page annotation = i.getAnnotation(Page.class);
			boolean isAccessible = i.isAccessible();
			Type type = i.getType();
			
			System.out.println(name);
			System.out.println(annotation);
			System.out.println(isAccessible);
			System.out.println(type);
			System.out.println();
		}
		
		TestGoogleTranslate instance = TestGoogleTranslate.class.newInstance();
		System.out.println(instance);
	}
}
