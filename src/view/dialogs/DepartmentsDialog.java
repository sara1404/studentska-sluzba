package view.dialogs;

import model.DatabaseReader;
import model.Professor;
import view.tabs.tabPanels.tabels.AbstractTableModelProfessorTeachSubjects;
import view.tabs.tables.AbstractTableModelDepartment;
import view.tabs.tables.DepartmentTable;

import javax.swing.*;

import bundle.LanguageSupport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentsDialog extends JDialog {
    DepartmentTable table;
    DepartmentsDialog cxt = this;
    AddDepartmentDirectorDialog addDepartmentDirectorDialog;
    public DepartmentsDialog(){
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("handlingDepartments"));
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 3/8, height * 3/4);
        setLocationRelativeTo(null);

        JButton editBtn = new JButton();
        editBtn.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/edit.png")));
        add(editBtn);


        table = new DepartmentTable();
        add(new JScrollPane(table));

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("message4"));
                }
                else{
                    addDepartmentDirectorDialog = new AddDepartmentDirectorDialog(cxt);
                    Professor departmentHead = DatabaseReader.getInstance().getDepartments().get(table.getSelectedRow()).getHead();
                    if(departmentHead != null)
                        addDepartmentDirectorDialog.getDepartmentDirectorField().setText(departmentHead.getName() + " " + departmentHead.getSurname());
                    addDepartmentDirectorDialog.determineButtonActivity();
                    addDepartmentDirectorDialog.setVisible(true);
                }

            }
        });
    }

    public DepartmentTable getDepartmentTable(){
        return table;
    }
    
	private void setTableColumnNames() {
		AbstractTableModelDepartment model = (AbstractTableModelDepartment) table.getModel();
		
		for(int i = 0; i < table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setHeaderValue(model.getColumnString(i));
		}
	}
    
    public void initComponenets() {
    	setTitle(LanguageSupport.getInstance().getResourceBundle().getString("handlingDepartments"));
    	setTableColumnNames();
    }
}
