package cz.fi.muni.jhuska.bc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReferencedBy {
	
	String clazz() default "";
	
	String css() default "";
	
	String id() default "";
	
	String linkText() default "";
	
	String name() default "";
	
	String partialLinkText() default "";
	
	String tagName() default "";
	
	String xPath() default "";
}
