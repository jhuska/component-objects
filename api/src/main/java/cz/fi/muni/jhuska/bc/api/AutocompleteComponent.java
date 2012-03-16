package cz.fi.muni.jhuska.bc.api;

import java.util.List;

public interface AutocompleteComponent extends Component {

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
	List<Suggestion> getAllSuggestions();

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
	 * of suggestions, then the missed suggestions are replaced by null value
	 * </p>
	 * 
	 * @return
	 */
	List<Suggestion> getFirstNSuggestions(int n);

	/**
	 * Returns the first suggestion if available, that is the most accurate
	 * suggestion from the list of suggestions. If there are no suggestions null
	 * is returned.
	 * 
	 * @return the first suggestion from the list of suggestions, of no
	 *         suggestions available null is returned
	 */
	Suggestion getFirstSuggestion();

	/**
	 * <p>
	 * Types to the autocomplete input the provided string at once and returns
	 * the suggestions if provided.
	 * </p>
	 * <p>
	 * That is it types the whole string value of param <code>string</code> to
	 * the input on which the autocomplete function is binded and returns all
	 * provided suggestions, if there are no suggestions empty list is returned.
	 * </p>
	 * 
	 * @param string
	 *            the characters which are about to write to the autocomplete
	 *            input
	 * @return list with all provided suggestions, if there are no suggestions
	 *         after typing empty list is returned
	 */
	List<Suggestion> typeAtOnce(String string);

	/**
	 * <p>
	 * Types the provided string to the autocomplete input,but character by
	 * character, and when there are suggestions, they are saved in separated
	 * lists and then returned wrapped into one list.
	 * </p>
	 * <p>
	 * That is when you provide for example string - Blah, then the char B is
	 * typed, and all suggestions are saved in one list, then it types char l
	 * and all other (even when they are repeated) suggestions are saved in
	 * second list, and so forth. When whole param is typed then all this lists
	 * are saved and returned as one list.
	 * </p>
	 * <p>
	 * If there are some characters of the provided string, which do not
	 * provided any suggestion when they are typed, then their suggestions are
	 * replaced by null value.
	 * 
	 * @param string
	 *            the string which will be typed sequentially into autocomplete
	 *            input
	 * @return list of lists of <code>Suggestions</code> with all suggestions
	 *         which was rendered during sequentially typing of the param
	 *         <code>string</code>
	 */
	List<List<String>> typeCharByChar(String string);

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
	public interface Suggestion {

		/**
		 * Returns the string representation of this suggestion.
		 * 
		 * @return
		 */
		String getValue();
	}
}
