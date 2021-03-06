package view.tabs;

import java.awt.Component;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import view.tabs.tabPanels.SubjectsNotPassedStudent;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;
import RowFilters.RowFilterStudent;
import bundle.LanguageSupport;
import model.DatabaseReader;
import view.MainFrame;
import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.AbstractTableModelSubject;
import view.tabs.tables.ProfessorTable;
import view.tabs.tables.StudentTable;
import view.tabs.tables.SubjectTable;

public class MainTab extends JTabbedPane {
	private StudentTable studentTable;
	private SubjectTable subjectTable;
	private ProfessorTable professorTable;
	private MainFrame frame;
	private JLabel tabName1;
	private JLabel tabName2;
	private JLabel tabName3;
	
	public MainTab(MainFrame mainFrame) {
		super();
		frame = mainFrame;
		tabName1 = new JLabel(LanguageSupport.getInstance().getResourceBundle().getString("tabName1"));

		studentTable = new StudentTable(frame);
		add(LanguageSupport.getInstance().getResourceBundle().getString("tabName1"), new JScrollPane(studentTable));
		professorTable = new ProfessorTable(frame);
		add(LanguageSupport.getInstance().getResourceBundle().getString("tabName2"), new JScrollPane(professorTable));
		subjectTable = new SubjectTable(frame);
		add(LanguageSupport.getInstance().getResourceBundle().getString("tabName3"), new JScrollPane(subjectTable));
		
	}

	
	public String getIndexOfSelectedStudent() {
		int row = studentTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("mesage5"));
			return null;
		}
		String index = (String) studentTable.getValueAt(row, 0);
		return index;
	}
	

	

	public String getIdOfSelectedSubject() {
		int row = subjectTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("mesage7"));
			return null;
		}
		String index = (String) subjectTable.getValueAt(row, 0);
		return index;
	}

	public String getIdOfSelectedProfessor() {
		int row = professorTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("mesage6"));
			return null;
		}
		String id = (String) professorTable.getValueAt(row, 4);
		return id;

	}

	public int getSelectedRowInStudentTable() {
		return studentTable.getSelectedRow();
	}

	public int getSelectedRowInSubjectTable() {
		return subjectTable.getSelectedRow();
	}

	public int getSelectedRowInProfessorTable() {
		return professorTable.getSelectedRow();
	}

	public StudentTable getStudentTable() {
		return studentTable;
	}

	public SubjectTable getSubjectTable() {
		return subjectTable;
	}

	public ProfessorTable getProfessorTable() {
		return professorTable;
	}
	
	private void setTableColumnNames() {
		AbstractTableModelStudent model = (AbstractTableModelStudent)studentTable.getModel();
		AbstractTableModelProfessor modelProf = (AbstractTableModelProfessor) professorTable.getModel();
		AbstractTableModelSubject modelSub = (AbstractTableModelSubject) subjectTable.getModel();
		
		for(int i = 0; i < studentTable.getColumnCount();i++) {
			studentTable.getColumnModel().getColumn(i).setHeaderValue(model.getColumnString(i));
		}
		for(int i = 0; i < professorTable.getColumnCount(); i++) {
			professorTable.getColumnModel().getColumn(i).setHeaderValue(modelProf.getColumnString(i));
		}
		for(int i = 0; i < subjectTable.getColumnCount(); i++) {
			subjectTable.getColumnModel().getColumn(i).setHeaderValue(modelSub.getColumnString(i));
		}
		
	}
	
	
	public void initComponents() {
		ResourceBundle bundle = LanguageSupport.getInstance().getResourceBundle();
		this.setTitleAt(0, bundle.getString("tabName1"));
		this.setTitleAt(1, bundle.getString("tabName2"));	
		this.setTitleAt(2, bundle.getString("tabName3"));	
		setTableColumnNames();
	}
}
