package view.tabs.tabPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ShowProfessorTeachSubjectsController;
import model.DatabaseReader;
import model.Professor;
import utils.Utils;
import view.MainFrame;
import view.dialogs.AssignSubjectToProfessor;
import view.tabs.tabPanels.tabels.ProfessorTeachSubjectsTable;

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
			
			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AssignSubjectToProfessor dialog = new AssignSubjectToProfessor();
					dialog.setVisible(true);
				}
			});
			
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
