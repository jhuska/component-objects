package cz.fi.muni.jhuska.bc.api;

import java.util.List;

/**
 * <p>
 * Autocomplete component represents an input with autocomplete function.
 * </p>
 * <p>
 * That is when you start typing, some suggestions are offered to you, which you
 * can choose from, to fill in the input faster.
 * </p>
 * 
 * @author jhuska
 * 
 */
public interface AutocompleteComponent<T> extends Component {//TODO mal by byt genericky podla toho aky ma typ v suggestion

	/**
	 * Determines whether the suggestion list is visible, that is whether there
	 * are some suggestions rendered.
	 * 
	 * @return true when there are suggestions visible, false otherwise
	 */
	boolean areSuggestionsAvailable();

	/**
	 * Returns all suggestions available, also these which need to be scrolled
	 * down to be visible.
	 * 
	 * @return all suggestions
	 */
	List<Suggestion<T>> getAllSuggestions();

	/**
	 * <p>
	 * Returns first n suggestions, that is the the first n most accurate
	 * suggestions, if there are some available.
	 * </p>
	 * <p>
	 * If there are no suggestions rendered, then empty list is returned.
	 * </p>
	 * <p>
	 * If the requested number of suggestions is bigger than the actual number
	 * of suggestions, then only available suggestions are returned.
	 * </p>
	 * 
	 * @return
	 */
	List<Suggestion<T>> getFirstNSuggestions(int n);

	/**
	 * Returns the first suggestion if available, that is the top
	 * suggestion from the list of suggestions. If there are no suggestions null
	 * is returned.
	 * 
	 * @return the first suggestion from the list of suggestions, of no
	 *         suggestions available null is returned
	 */
	Suggestion<T> getFirstSuggestion();

	/**
	 * Returns the suggestion which is in order determined by param
	 * <code>order</code>. If there is no so many suggestions, then null
	 * is returned.
	 * 
	 * @param order
	 * @return
	 */
	Suggestion<T> getNthSuggestion(int order);

	/**
	 * <p>
	 * Types to the autocomplete input the provided string and returns
	 * the suggestions if provided.
	 * </p>
	 * <p>
	 * That is it types the whole string value of param <code>string</code> to
	 * the input on which the autocomplete function is binded and returns all
	 * provided suggestions, if there are no suggestions, empty list is returned.
	 * </p>
	 * 
	 * @param string
	 *            the characters which are about to write to the autocomplete
	 *            input
	 * @return list with all provided suggestions, if there are no suggestions
	 *         after typing empty list is returned
	 */
	List<Suggestion<T>> typeAtOnce(String string);

	/**
	 * <p>
	 * Autocompletes the input with given suggestion
	 * </p>
	 * <p>
	 * That is it chooses the suggestion from the list of available suggestions.
	 * If that particular suggestion is not available, or there are no
	 * suggestions at all, then it is just ignored, and false is returned.
	 * </p>
	 * 
	 * @param sugg
	 *            the suggestion, it will be autocompleted with
	 * @return true when it was successfully autocompleted by provided
	 *         suggestion, false otherwise
	 */
	boolean autocompleteWithSuggestion(Suggestion sugg);

	/**
	 * <p>
	 * Autocompletes the input with suggestion determined by param
	 * <code>sugg</code>, and the suggestion is chosen by the way determined by
	 * param <code>scrollingType</code>
	 * </p>
	 * <p>
	 * That is it chooses the suggestion from the list of available suggestions.
	 * If that particular suggestion is not available, or there are no
	 * suggestions at all, then it is just ignored, and false is returned.
	 * </p>
	 * 
	 * @param sugg
	 *            the suggestion, it will be autocompleted with
	 * @param scrollingType
	 *            the scrolling type of the suggestion selection
	 * @return true when it was successfully autocompleted by provided
	 *         suggestion, false otherwise
	 */
	boolean autocompleteWithSuggestion(Suggestion sugg,
			ScrollingType scrollingType);

	/**
	 * The suggestion provided by autocomplete function of particular input.
	 * 
	 * @author jhuska
	 */
	public interface Suggestion<T> {

		/**
		 * Returns the value of generic type of this suggestion
		 * 
		 * @return
		 */
		T getValue();
		
		/**
		 * Returns the value of the input for which this suggestion was offered.
		 * 
		 * @return
		 */
		String getInput();
	}
}
