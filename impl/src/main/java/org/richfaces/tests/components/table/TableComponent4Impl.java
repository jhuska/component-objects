package org.richfaces.tests.components.table;

import java.util.List;

import org.jboss.arquillian.graphene.spi.components.scrolling.DataScrollerComponent;
import org.jboss.arquillian.graphene.spi.components.table.CellFunction;
import org.jboss.arquillian.graphene.spi.components.table.Column;
import org.jboss.arquillian.graphene.spi.components.table.ColumnFunction;
import org.jboss.arquillian.graphene.spi.components.table.Footer;
import org.jboss.arquillian.graphene.spi.components.table.Cell;
import org.jboss.arquillian.graphene.spi.components.table.Header;
import org.jboss.arquillian.graphene.spi.components.table.Row;
import org.jboss.arquillian.graphene.spi.components.table.RowFunction;
import org.jboss.arquillian.graphene.spi.components.table.TableComponent4;
import org.openqa.selenium.WebElement;

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
