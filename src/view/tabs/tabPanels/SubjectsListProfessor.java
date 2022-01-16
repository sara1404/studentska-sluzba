package view.tabs.tabPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bundle.LanguageSupport;
import controller.ShowProfessorTeachSubjectsController;
import model.DatabaseReader;
import model.Professor;
import utils.Utils;
import view.MainFrame;
import view.tabs.tabPanels.tabels.AbstractTableModelProfessorTeachSubjects;
import view.dialogs.AssignSubjectToProfessor;
import view.tabs.tabPanels.tabels.ProfessorTeachSubjectsTable;
import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.AbstractTableModelSubject;

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
			
			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AssignSubjectToProfessor dialog = new AssignSubjectToProfessor();
					dialog.setVisible(true);
				}
			});
			
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
