package cz.fi.muni.jhuska.bc.components.table;

import cz.fi.muni.jhuska.bc.components.common.ComponentsContainer;

/**
 * Represents one particular cell of the table.
 * 
 * @author jhuska
 */
public interface Cell<T> extends ComponentsContainer<T> {

	Row whichRow();

	Column<T> whichColumn();
}