package cz.fi.muni.jhuska.bc.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.channels.IllegalSelectorException;

import cz.fi.muni.jhuska.bc.annotations.ReferencedBy;
import cz.fi.muni.jhuska.bc.annotations.Root;


public class Factory {

	/**
	 * 
	 * @param clazz
	 * @return
	 * @param <T>
	 *            the final implementation of component
	 */
	public static <T extends AbstractComponent> T initializeComponent(Class<T> clazz) {
		AbstractComponent component = instantiateComponent(clazz);
		
		// TODO read fields of component class and obtain root types and other elements
		Field[] declaredFields = clazz.getDeclaredFields();
		
		// TODO initialize root
		RootReference rootReference = component.getRootReference();
		WebElement root;
		
		// TODO initialize other elements
		for(Field i : declaredFields) {
			
			Annotation[] annotations = i.getAnnotations();
			for(Annotation j : annotations) {

				if( j instanceof Root ) {
					
				}
				
				if( j instanceof ReferencedBy ) {
					
					String referenceBy = ((ReferencedBy) j).clazz();
					try {
						
						Class cls = Class.forName("cz.fi.muni.jhuska.bc.impl.WebElementImpl");
						WebElement element = (WebElement) cls.newInstance();
						element.setParent(rootReference);
						element.setReference(referenceBy);
						i.setAccessible(true);
						i.set(component, element);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
 		}
		
		return (T) component;
	}
	
	public static <T extends AbstractComponent> T instantiateComponent(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException(e);
		}
	}
}
