package fmi.informatics.gui;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;
import fmi.informatics.extending.Professor;
import fmi.informatics.extending.Student;

// Създаваме клас PersonDataModel
public class PersonDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private Person[] people;

	// constructor
	public PersonDataModel(Person[] people) {
		this.people = people;
	}

	@Override
	public int getColumnCount() {
		return 9; // брой колони в таблицата
	}

	@Override
	public int getRowCount() {
		return people.length; // брой редове в таблицата
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return people[rowIndex].getName();
			case 1:
				return people[rowIndex].getEgn();
			case 2:
				return people[rowIndex].getAge();
			case 3:
				return people[rowIndex].getHeight();
			case 4:
				return people[rowIndex].getWeight();
			case 5:
				if (people[rowIndex] instanceof Student) {
					String uni = ((Student) people[rowIndex]).getUniversity();
					return uni;
				}else {
					return "----------";
				}
			case 6:
				if (people[rowIndex] instanceof Student) {
					int facNum = ((Student) people[rowIndex]).getFacNumber();
					return facNum;
				}else {
					return"---------";
				}
			case 7:
				if (people[rowIndex] instanceof Student) {
					String spec = ((Student) people[rowIndex]).getSpeciality();
					return spec;
				}else {
					return"---------";
				}
			case 8:
				if (people[rowIndex] instanceof Professor) {
					String title = ((Professor) people[rowIndex]).getTitle();
					return title;
				}else {
					return"---------";
				}
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Име";
			case 1:
				return "ЕГН";
			case 2:
				return "Години";
			case 3:
				return "Височина";
			case 4:
				return "Тегло";
			case 5:
				return "Университет";
			case 6:
				return "Фак.номер";
			case 7:
				return "Специалност";
				case 8:
					return "Tитла";
				
	
			default:
				return super.getColumnName(column);
		}
	}
}
