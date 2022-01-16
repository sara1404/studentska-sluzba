package view.tabs.tabPanels;

import javax.swing.*;

import bundle.LanguageSupport;
import controller.ShowProfessorTeachSubjectsController;
import model.DatabaseReader;
import model.Professor;
import utils.Utils;
import view.MainFrame;
import view.tabs.tabPanels.tabels.AbstractTableModelProfessorTeachSubjects;
import view.tabs.tabPanels.tabels.ProfessorTeachSubjectsTable;
import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.AbstractTableModelSubject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectsListProfessor extends JPanel{
	
		JButton addBtn;
		JButton removeBtn;
		ProfessorTeachSubjectsTable table;

		SubjectsListProfessor cxt = this;
		public SubjectsListProfessor() {
			JPanel pan = new JPanel();
			BoxLayout box = new BoxLayout(pan, BoxLayout.X_AXIS);
			pan.setLayout(box);
			
			addBtn  = new JButton();
			addBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("addSubBtn"));
			Utils.setCursor(addBtn);
			pan.add(addBtn);
			
			
			
			removeBtn = new JButton();
			removeBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeSubBtn"));
			pan.add(removeBtn);
			Utils.setCursor(removeBtn);

			add(pan);



			table = new ProfessorTeachSubjectsTable();
			add(new JScrollPane(table));
			
			


			removeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Professor professor = DatabaseReader.getInstance().getProfessors().get(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable());
					ShowProfessorTeachSubjectsController.getInstance().removeSubjectFromProfessor(table, professor, cxt);
				}
			});
		}
		
		private void setTableColumnNames() {
			AbstractTableModelProfessorTeachSubjects model = (AbstractTableModelProfessorTeachSubjects) table.getModel();
			
			for(int i = 0; i < table.getColumnCount();i++) {
				table.getColumnModel().getColumn(i).setHeaderValue(model.getColumnString(i));
			}
		}
		
		public void initComponents() {
			addBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("addSubBtn"));
			removeBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeSubBtn"));
			setTableColumnNames();
		}

}
