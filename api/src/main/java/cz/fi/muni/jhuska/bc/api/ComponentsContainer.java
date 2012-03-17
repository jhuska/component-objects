package cz.fi.muni.jhuska.bc.api;

import java.util.List;

public interface ComponentsContainer extends Component {

	/**
	 * Adds given component to the content of the popup.
	 * 
	 * @param component
	 *            the particular component to be added to content
	 */
	Component addComponent(Component component);

	/**
	 * Removes given component from the content of the popup.
	 * 
	 * @param component
	 *            the particular component to be removed from content
	 */
	Component removeComponent(Component component);

	/**
	 * Returns the content of the popup, in other words List containing all
	 * components from the particular popup.
	 * 
	 * @return
	 */
	List<Component> getContent();

}
