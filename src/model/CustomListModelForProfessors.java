package model;

import java.util.Vector;

import javax.swing.AbstractListModel;

public class CustomListModelForProfessors extends AbstractListModel<String>{
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return DatabaseReader.getInstance().getProfessors().size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		Professor professor = DatabaseReader.getInstance().getProfessors().get(index);
		return professor.getName() + " " + professor.getSurname();
	}

}
