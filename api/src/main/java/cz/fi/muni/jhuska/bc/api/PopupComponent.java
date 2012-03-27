package cz.fi.muni.jhuska.bc.api;

/**
 * <p>
 * PopupComponent represents a popup which can be showed and then closed.
 * </p>
 * <p>
 * There are various implementations possible. Like modal popup, popup panel,
 * popup panel which is showed after clicking or hovering on or over someting,
 * and so on.
 * </p>
 * 
 * @author jhuska
 * 
 */
public interface PopupComponent<T> extends ComponentsContainer {

	/**
	 * Returns whether this popup is visible.
	 * @return
	 */
	boolean isVisible();
}
