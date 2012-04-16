package cz.fi.muni.jhuska.bc.ftest.components.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonBean {

	private List<Person> persons;
	
	@PostConstruct
	public void initPersons() {
		persons = new ArrayList<PersonBean.Person>();
		
		persons.add(new Person("Juraj", "Huska", 22, "Brno 60200", "4511254"));
		persons.add(new Person("Omar", "Omnibus", 12, "Prague", "001225478"));
		persons.add(new Person("Element", "Primary", 44, "Space station", "77444541"));
		persons.add(new Person("Mother", "Goose", 60, "USA", "0021456458"));
		persons.add(new Person("Example", "Surname", 33, "Address", "Phone"));
		persons.add(new Person("Ondrej", "Novy", 22, "Bratislava", "887897"));
		persons.add(new Person("Nimbus", "Fekete", 2, "Prievidza", "77711425"));
		persons.add(new Person("Mike", "Tyson", 55, "New York", "7894120"));
	}

	public class Person {

		private String firstName;
		private String surnameName;
		private Integer age;
		private String address;
		private String phone;

		public Person(String firstName, String surnameName, Integer age,
				String address, String phone) {
			super();
			this.firstName = firstName;
			this.surnameName = surnameName;
			this.age = age;
			this.address = address;
			this.phone = phone;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getSurnameName() {
			return surnameName;
		}

		public void setSurnameName(String surnameName) {
			this.surnameName = surnameName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
