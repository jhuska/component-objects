package cz.fi.muni.jhuska.bc.api;

/**
 * It should ensure in the constructor that it is going represent either
 * WebElement, Page object or Component.
 * 
 * @author jhuska
 * 
 */
public interface NestedElements<T> {

	T getValue();
}
