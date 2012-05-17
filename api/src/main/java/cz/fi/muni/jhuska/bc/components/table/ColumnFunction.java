package cz.fi.muni.jhuska.bc.components.table;

public interface ColumnFunction<T> {

	boolean accept(Column<T> column);
}
