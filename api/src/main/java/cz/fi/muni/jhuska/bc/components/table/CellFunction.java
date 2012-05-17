package cz.fi.muni.jhuska.bc.components.table;

/**
 * 
 * @author jhuska
 * 
 */
public interface CellFunction<T> {

	boolean accept(Cell<T> cell);
}