package cz.fi.muni.jhuska.bc.components.numberSpinner;

import cz.fi.muni.jhuska.bc.components.common.Component;

public interface NumberSpinnerComponent extends Component {
	
	void increase();
	
	void decrease();
	
	void fillInTheInput(Integer integer);
	
	Integer getValue();
}
