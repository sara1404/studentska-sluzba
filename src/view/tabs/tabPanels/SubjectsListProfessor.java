package view.tabs.tabPanels;

import javax.swing.*;

import controller.ShowProfessorTeachSubjectsController;
import model.DatabaseReader;
import model.Professor;
import utils.Utils;
import view.MainFrame;
import view.tabs.tabPanels.tabels.ProfessorTeachSubjectsTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectsListProfessor extends JPanel{

		SubjectsListProfessor cxt = this;
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


			removeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Professor professor = DatabaseReader.getInstance().getProfessors().get(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable());
					ShowProfessorTeachSubjectsController.getInstance().removeSubjectFromProfessor(table, professor, cxt);
				}
			});
		}

}
