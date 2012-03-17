package cz.fi.muni.jhuska.bc.api;

import java.util.List;

public interface DataTableComponent extends Component {

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
	Cell getCell(Row row, Column column);

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
	Column getFirstColumn();

	/**
	 * Returns the last column of the table, the footer column if available, is
	 * not counted.
	 * 
	 * @return
	 */
	Column getLastColumn();

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
	 * If such header does not exist or that header is associated rather with column,
	 * then null is returned.
	 * </p>
	 * 
	 * @param header the header of the requested row
	 * @return the particular row, or null if it does not exist
	 */
	Row getRow(Header header);
	
	/**
	 * <p>
	 * Returns the column with the order determined by given param
	 * <code>order</code>.
	 * </p>
	 * <p>
	 * Columns are indexed from 0. The header column if available is not counted.
	 * </p>
	 * 
	 * @param order
	 *            the order of the column
	 * @return the particular column, or null if it does not exist
	 */
	Column getColumn(int order);
	
	/**
	 * <p>
	 * Returns the column, determined by the row header.
	 * </p>
	 * <p>
	 * If such header does not exist or that header is associated rather with row,
	 * then null is returned.
	 * </p>
	 * 
	 * @param header the header of requested column
	 * @return the particular column, or null if it does not exist
	 */
	Column getColumn(Header header);

	/**
	 * Represents any part of the table.
	 * 
	 * @author jhuska
	 */
	public interface PartOfTable {

		/**
		 * Returns list with all cells from a particular table area
		 * 
		 * @return
		 */
		List<Cell> getAllCells();

		/**
		 * Returns the number of cells from particular table area
		 * 
		 * @return
		 */
		int getNumberOfCells();
	}

	/**
	 * Represents the header of the column or row.
	 * 
	 * @author jhuska
	 */
	public interface Header extends PartOfTable {

	}

	/**
	 * Represents the footer of the column or row.
	 * 
	 * @author jhuska
	 */
	public interface Footer extends PartOfTable {

	}

	/**
	 * <p>
	 * Represents the row of the table.
	 * </p>
	 * <p>
	 * It should be possible to determine the particular row either by the
	 * header or footer, but most often by the order number. Rows are indexed
	 * from 0.
	 * </p>
	 * 
	 * @author jhuska
	 */
	public interface Row extends PartOfTable {

		/**
		 * Sets the number of columns you want to have in this particular row.
		 * It is useful for tables with lot of columns.
		 * 
		 * @param numberOfColumns
		 */
		void setNumberOfColumns(int numberOfColumns);
	}

	/**
	 * <p>
	 * Represents the column of the table.
	 * </p>
	 * <p>
	 * It should be possible to determine the particular column either by the
	 * header or footer, but most often by the order number. Columns are indexed
	 * from 0.
	 * </p>
	 * 
	 * @author jhuska
	 */
	public interface Column extends PartOfTable {

		/**
		 * <p>
		 * Sets the number of rows you want to have in this particular column.
		 * It is useful for tables with lot of rows.
		 * </p>
		 * 
		 * @param numberOfRows
		 */
		void setNumberOfRows(int numberOfRows);
	}

	/**
	 * Represents one particular cell of the table.
	 * 
	 * @author jhuska
	 */
	public interface Cell extends PartOfTable {
		String getValue();

		Row whichRow();

		Column whichColumn();
	}
}
