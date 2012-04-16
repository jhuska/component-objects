package cz.fi.muni.jhuska.bc.impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.components.scrolling.DataScrollerComponent;
import cz.fi.muni.jhuska.bc.components.table.Cell;
import cz.fi.muni.jhuska.bc.components.table.Column;
import cz.fi.muni.jhuska.bc.components.table.DataTableComponent6ColTypes;
import cz.fi.muni.jhuska.bc.components.table.Footer;
import cz.fi.muni.jhuska.bc.components.table.Header;
import cz.fi.muni.jhuska.bc.components.table.Row;

public class DataTable6ColTypesImpl<A, B, C, D, E, F> implements DataTableComponent6ColTypes {

	@Override
	public void setDateScroller(DataScrollerComponent scroller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfCells() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cell<?>> findCell(Function function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cell<?> getCell(Row row, Column<?> column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Header> getTableHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Footer> getTableFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row getFirstRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row getLastRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<?> getFirstColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<?> getLastColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row getRow(int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row getRow(Header header) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<?> getColumn(int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<?> getColumn(Header header) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoot(WebElement root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebElement getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
