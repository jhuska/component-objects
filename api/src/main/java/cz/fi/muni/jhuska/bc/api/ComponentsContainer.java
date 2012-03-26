package cz.fi.muni.jhuska.bc.api;

import java.util.List;

/**
 * ComponentsContainer represents a container for components, in other words a
 * component which can contain other components, which you can easily access.
 * 
 * @author jhuska
 * 
 */
public interface ComponentsContainer<T extends NestedElements> extends Component {

	/**
	 * Returns the content of the popup, in other words List containing all
	 * components from the particular popup.
	 * 
	 * @return
	 */
	List<NestedElements> getContent();

}
