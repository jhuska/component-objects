package cz.fi.muni.jhuska.bc.components.common;

import java.util.List;

import cz.fi.muni.jhuska.bc.components.NestedElements;

/**
 * ComponentsContainer represents a container for components, in other words a
 * component which can contain other components, which you can easily access.
 * 
 * @author jhuska
 * 
 */
public interface ComponentsContainer<T> extends Component {

	List<NestedElements<T>> getContent();

}
