package cz.fi.muni.jhuska.bc.api;

import java.util.List;

/**
 * ComponentsContainer represents a container for components, in other words a
 * component which can contain other components, which you can easily access.
 * 
 * @author jhuska
 * 
 */
public interface ComponentsContainer extends Component {

	/**
	 * 
	 * @return
	 */
	List<NestedElements> getContent();

}
