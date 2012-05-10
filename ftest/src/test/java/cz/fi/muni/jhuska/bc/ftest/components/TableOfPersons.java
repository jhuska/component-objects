package cz.fi.muni.jhuska.bc.ftest.components;


import java.util.List;

import cz.fi.muni.jhuska.bc.components.table.Row;
import cz.fi.muni.jhuska.bc.impl.DataTable6Impl;

public class TableOfPersons extends DataTable6Impl<String, String, Integer, String, String, String> {

	public Person getPerson(Row row) {
		Person person = new Person();
		person.setFirstName( row.getCell(getColumn1()).getContent().get(0).getValue() );
		person.setLastName( row.getCell(getColumn2()).getContent().get(0).getValue() );
		person.setAge( row.getCell(getColumn3()).getContent().get(0).getValue() );
		person.setAddress( row.getCell(getColumn4()).getContent().get(0).getValue() );
		person.setPhone( row.getCell(getColumn5()).getContent().get(0).getValue() );
		person.setJob( row.getCell(getColumn6()).getContent().get(0).getValue() );
		
		return person;
	}
	
	public Integer getSumOfAges() {
		
		Integer sum = new Integer(0);
		
		List<Row> rows = getAllRows();
		for(Row i : rows) {
			Integer age = i.getCell(getColumn3()).getContent().get(0).getValue();
			sum += age;
		}
		
		return sum;
	}
	
	public class Person {
		String firstName;
		String lastName;
		Integer age;
		String address;
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
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
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		String phone;
		String job;
	}
	
	
}
