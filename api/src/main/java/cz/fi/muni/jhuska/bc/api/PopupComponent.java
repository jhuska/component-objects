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
public interface PopupComponent extends ComponentsContainer {

	/**
	 * <p>
	 * Shows the popup panel.
	 * </p>
	 * <p>
	 * It can be done in different ways, for example by clicking, hovering over
	 * something, in other words it depends on the implementation.
	 * </p>
	 */
	void showPopup();

	/**
	 * <p>
	 * Hides the popup panel.
	 * </p>
	 * <p>
	 * It can be done in different ways, for example by clicking, hovering out
	 * from something, in other words it depends on the implementation.
	 * </p>
	 */
	void hidePopup();
}
