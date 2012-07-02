package org.richfaces.tests.components.objects.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonBean {

	private List<Person> persons;
	
	public List<String> autocomplete(String prefix) {
		List<String> allCities = new ArrayList<String>();
		allCities.add("Brno");
		allCities.add("Prague");
		allCities.add("Bratislava");
		allCities.add("London");
		allCities.add("Leongard");
		allCities.add("Munich");
		allCities.add("Rome");
		allCities.add("Berlin");
		
		List<String> rightCities = new ArrayList<String>();
		for(String i : allCities) {
			if(i.contains(prefix)) {
				rightCities.add(i);
			}
		}
		
		return rightCities;
	}
	
	@PostConstruct
	public void initPersons() {
		persons = new ArrayList<Person>();
		
		persons.add(new Person("Juraj", "Huska", 22, "Brno 60200", "4511254"));
		persons.add(new Person("Omar", "Omnibus", 12, "Prague", "001225478"));
		persons.add(new Person("Element", "Primary", 44, "Space station", "77444541"));
		persons.add(new Person("Mother", "Goose", 60, "USA", "0021456458"));
		persons.add(new Person("Example", "Surname", 33, "Address", "Phone"));
		persons.add(new Person("Ondrej", "Novy", 22, "Bratislava", "887897"));
		persons.add(new Person("Nimbus", "Fekete", 2, "Prievidza", "77711425"));
		persons.add(new Person("Mike", "Tyson", 55, "New York", "7894120"));
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
