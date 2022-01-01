package view.tabs.tabPanels;

import javax.swing.*;

import utils.Utils;
import view.tabs.tabPanels.tabels.ProfessorTeachSubjectsTable;

public class SubjectsListProfessor extends JPanel{
	
		public SubjectsListProfessor() {
			JPanel pan = new JPanel();
			BoxLayout box = new BoxLayout(pan, BoxLayout.X_AXIS);
			pan.setLayout(box);
			
			JButton addBtn  = new JButton();
			addBtn.setText("Dodaj predmet");
			Utils.setCursor(addBtn);
			pan.add(addBtn);
			
			
			
			JButton removeBtn = new JButton();
			removeBtn.setText("Obrisi predmet");
			pan.add(removeBtn);
			Utils.setCursor(removeBtn);

			add(pan);

			ProfessorTeachSubjectsTable table = new ProfessorTeachSubjectsTable();
			add(new JScrollPane(table));
		}

}
