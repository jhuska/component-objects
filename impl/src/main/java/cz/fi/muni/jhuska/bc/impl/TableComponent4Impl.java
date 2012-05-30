package cz.fi.muni.jhuska.bc.impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.components.scrolling.DataScrollerComponent;
import cz.fi.muni.jhuska.bc.components.table.Cell;
import cz.fi.muni.jhuska.bc.components.table.CellFunction;
import cz.fi.muni.jhuska.bc.components.table.Column;
import cz.fi.muni.jhuska.bc.components.table.ColumnFunction;
import cz.fi.muni.jhuska.bc.components.table.Footer;
import cz.fi.muni.jhuska.bc.components.table.Header;
import cz.fi.muni.jhuska.bc.components.table.Row;
import cz.fi.muni.jhuska.bc.components.table.RowFunction;
import cz.fi.muni.jhuska.bc.components.table.TableComponent4;

public class TableComponent4Impl<A, B, C, D> implements
		TableComponent4<A, B, C, D> {

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
	public <T> List<Cell<T>> findCells(CellFunction<T> function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Row> findRow(RowFunction function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Column<T>> findColumns(ColumnFunction<T> function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> Cell<T> getCell(Row row, Column<T> column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getTableHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Footer getTableFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Row> getAllRows() {
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
	public Row getRow(int order) {
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

	@Override
	public Column<A> getColumn1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<B> getColumn2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<C> getColumn3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column<D> getColumn4() {
		// TODO Auto-generated method stub
		return null;
	}
}
