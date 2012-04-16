package cz.fi.muni.jhuska.bc.components.table;

import java.util.List;

import cz.fi.muni.jhuska.bc.components.common.Component;
import cz.fi.muni.jhuska.bc.components.scrolling.DataScrollerComponent;

/**
 * <p>
 * DataTableComponent represents a table.
 * </p>
 * <p>
 * It consist from cells, which are joined into rows and columns.
 * </p>
 * 
 * @author jhuska
 * 
 */
public interface DataTableComponent extends Component {

	/**
	 * Associates this data table with a given data scroller
	 * 
	 * @param scroller
	 *            the scroller to associate this table with
	 */
	void setDateScroller(DataScrollerComponent scroller);

	/**
	 * <p>
	 * Returns the total number of rows in this particular table.
	 * </p>
	 * <p>
	 * The <code>rowspan</code> html atribute is not considered, in other words
	 * the row with <code>rowspan</code> equals 2 is considered as one row.
	 * </p>
	 * 
	 * @return
	 */
	int getNumberOfRows();

	/**
	 * <p>
	 * Returns total number of cells in this particular table.
	 * </p>
	 * 
	 * @return
	 */
	int getNumberOfCells();

	/**
	 * 
	 * @author jhuska
	 * 
	 */
	public interface Function {

		boolean accept(Cell<?> cell);
	}

	List<Cell<?>> findCell(Function function);

//	List<Column<?>> findColumn(Function function);

//	List<Row> findRow(Function function);

	/**
	 * <p>
	 * Returns the total number of columns in this particular table.
	 * </p>
	 * <p>
	 * The <code>colspan</code> html atribute is not considered, in other words
	 * the column with <code>colspan</code> equals 2 is considered as one
	 * column.
	 * </p>
	 * 
	 * @return
	 */
	int getNumberOfColumns();

	/**
	 * Returns the particular cell, the cell with coordinations determined by
	 * given row and column.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	Cell<?> getCell(Row row, Column<?> column);

	/**
	 * Returns the list of all header cells, in other words the whole table
	 * header.
	 * 
	 * @return
	 */
	List<Header> getTableHeader();

	/**
	 * Returns the list of all footer cells, in other words the whole table
	 * footer.
	 * 
	 * @return
	 */
	List<Footer> getTableFooter();

	/**
	 * Returns the first row of the table, the header row if available, is not
	 * counted.
	 * 
	 * @return
	 */
	Row getFirstRow();

	/**
	 * Returns the last row of the table, the footer row if available, is not
	 * counted.
	 * 
	 * @return
	 */
	Row getLastRow();

	/**
	 * Returns the first column of the table, the header column if available, is
	 * not counted.
	 * 
	 * @return
	 */
	Column<?> getFirstColumn();

	/**
	 * Returns the last column of the table, the footer column if available, is
	 * not counted.
	 * 
	 * @return
	 */
	Column<?> getLastColumn();

	/**
	 * <p>
	 * Returns the row with the order determined by given param
	 * <code>order</code>.
	 * </p>
	 * <p>
	 * Rows are indexed from 0. The header row if available is not counted.
	 * </p>
	 * 
	 * @param order
	 *            the order of the row
	 * @return the particular row, or null if it does not exist
	 */
	Row getRow(int order);

	/**
	 * <p>
	 * Returns the row, determined by the row header.
	 * </p>
	 * <p>
	 * If such header does not exist or that header is associated rather with
	 * column, then null is returned.
	 * </p>
	 * 
	 * @param header
	 *            the header of the requested row
	 * @return the particular row, or null if it does not exist
	 */
	Row getRow(Header header);

	/**
	 * <p>
	 * Returns the column with the order determined by given param
	 * <code>order</code>.
	 * </p>
	 * <p>
	 * Columns are indexed from 0. The header column if available is not
	 * counted.
	 * </p>
	 * 
	 * @param order
	 *            the order of the column
	 * @return the particular column, or null if it does not exist
	 */
	Column<?> getColumn(int order);

	/**
	 * <p>
	 * Returns the column, determined by the row header.
	 * </p>
	 * <p>
	 * If such header does not exist or that header is associated rather with
	 * row, then null is returned.
	 * </p>
	 * 
	 * @param header
	 *            the header of requested column
	 * @return the particular column, or null if it does not exist
	 */
	Column<?> getColumn(Header header);

//	public interface Structure {
//
//		LinkedList<Object> getTypes();
//		
//		void setTypes(LinkedList<Object> types);
//	}
//
//	/**
//	 * 
//	 * @author jhuska
//	 *
//	 */
//	public class StructureImpl implements DataTableComponent.Structure {
//
//		private LinkedList<Object> types;
//		
//		public StructureImpl(LinkedList<Object> types) {
//			super();
//			if(types == null) {
//				throw new IllegalArgumentException("Types param must not be null!");
//			}
//			this.types = types;
//		}
//
//		@Override
//		public LinkedList<Object> getTypes() {
//			return types;
//		}
//
//		@Override
//		public void setTypes(LinkedList<Object> types) {
//			if(types == null) {
//				throw new IllegalArgumentException("Types param must not be null!");
//			}
//			this.types = types;
//		}
//
//	}
	
//	/**
//	 * 
//	 * @param structure
//	 */
//	void setStructure(Structure structure);
}
