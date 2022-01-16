package view.dialogs;

import controller.SetDepartmentDirectorController;
import model.DatabaseReader;
import model.Department;
import model.ObserverNotifier;
import model.Professor;
import utils.WindowComponentBuilder;

import javax.swing.*;

import bundle.LanguageSupport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddDepartmentDirectorDialog extends JDialog{

    ArrayList<JButton> buttonsInAddDepartmentDirector;
    JTextField departmentDirectorField;
    JButton addBtn;
    JButton removeBtn;
    AssignProfessorToDepartmentDirectorDialog assignProfessorToDepartmentDirectorDialog = new AssignProfessorToDepartmentDirectorDialog(this);
    private DepartmentsDialog departmentsDialog;
    private AddDepartmentDirectorDialog ctx = this;
    JLabel departmentDirector;
    public AddDepartmentDirectorDialog(DepartmentsDialog departmentsDialog){
        this.departmentsDialog = departmentsDialog;
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addDirector"));
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 3/8, height * 1/3);
        setLocationRelativeTo(null);

        buttonsInAddDepartmentDirector = new ArrayList<>();

        JPanel temp = new JPanel();
        BoxLayout box1 = new BoxLayout(temp, BoxLayout.X_AXIS);
        temp.setLayout(box1);
        departmentDirector = new JLabel(LanguageSupport.getInstance().getResourceBundle().getString("departmentDirector"));
        departmentDirector.setForeground(Color.WHITE);
        departmentDirectorField = WindowComponentBuilder.createTextField();
        departmentDirectorField.setEditable(false);
        addBtn = new JButton();
        removeBtn = new JButton();
        addBtn.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/new.png")));
        addBtn.setPreferredSize(new Dimension(30, 30));
        addBtn.setMaximumSize(new Dimension(30, 30));
        removeBtn.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/remove.png")));
        removeBtn.setPreferredSize(new Dimension(30, 30));
        removeBtn.setMaximumSize(new Dimension(30, 30));
        temp.add(departmentDirector);
        temp.add(Box.createHorizontalStrut(20));
        temp.add(departmentDirectorField);
        temp.add(Box.createHorizontalStrut(10));
        temp.add(addBtn);
        temp.add(Box.createHorizontalStrut(10));
        temp.add(removeBtn);
        temp.setBackground(Color.DARK_GRAY);

        buttonsInAddDepartmentDirector.add(new JButton());
        buttonsInAddDepartmentDirector.add(new JButton());
        add(temp);
        add(WindowComponentBuilder.createButtons(buttonsInAddDepartmentDirector.get(0), buttonsInAddDepartmentDirector.get(1)));

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignProfessorToDepartmentDirectorDialog.setVisible(true);
            }
        });

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departmentDirectorField.setText("");
                determineButtonActivity();
            }
        });

        buttonsInAddDepartmentDirector.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetDepartmentDirectorController.getInstance().addDepartmentDirectorController(departmentsDialog, assignProfessorToDepartmentDirectorDialog, ctx);
                dispose();
            }
        });

        buttonsInAddDepartmentDirector.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        initComponents();
    }

    public void determineButtonActivity() {
        if(departmentDirectorField.getText().equals("")) {
            addBtn.setEnabled(true);
            removeBtn.setEnabled(false);
        }
        else{
            addBtn.setEnabled(false);
            removeBtn.setEnabled(true);
        }
    }
    public JTextField getDepartmentDirectorField(){
        return departmentDirectorField;
    }
    
    public void initComponents() {
    	setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addDirector"));
    	departmentDirector.setText(LanguageSupport.getInstance().getResourceBundle().getString("departmentDirector"));
    }
}
