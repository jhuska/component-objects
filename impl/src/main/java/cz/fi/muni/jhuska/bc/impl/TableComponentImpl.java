package cz.fi.muni.jhuska.bc.impl;

import java.util.List;

import org.openqa.selenium.WebElement;

import cz.fi.muni.jhuska.bc.components.scrolling.DataScrollerComponent;
import cz.fi.muni.jhuska.bc.components.table.Cell;
import cz.fi.muni.jhuska.bc.components.table.Column;
import cz.fi.muni.jhuska.bc.components.table.TableComponent;
import cz.fi.muni.jhuska.bc.components.table.Footer;
import cz.fi.muni.jhuska.bc.components.table.Header;
import cz.fi.muni.jhuska.bc.components.table.Row;

public class TableComponentImpl implements TableComponent {

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
	public int getNumberOfColumns() {
		// TODO Auto-generated method stub
		return 0;
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
	public <T> Cell<T> getCell(Row row, Column<T> column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Row> getAllRows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Footer getTableFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getTableHeader() {
		// TODO Auto-generated method stub
		return null;
	}
}
