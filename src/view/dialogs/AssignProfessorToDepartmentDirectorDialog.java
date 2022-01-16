package view.dialogs;

import model.CustomListModelForDepartmentDirector;
import model.CustomListModelForProfessors;
import model.DatabaseReader;

import javax.swing.*;

import bundle.LanguageSupport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignProfessorToDepartmentDirectorDialog extends JDialog {
    JList<String> professorList;
    JButton applyBtn;
    JButton cancelBtn;
    AddDepartmentDirectorDialog addDepartmentDirectorDialog;
    public AssignProfessorToDepartmentDirectorDialog(AddDepartmentDirectorDialog dialog){
        addDepartmentDirectorDialog = dialog;
        setModalityType(DEFAULT_MODALITY_TYPE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("chooseDirector"));
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1/4, height * 1/3);
        setLocationRelativeTo(null);

        professorList = new JList<>(new CustomListModelForDepartmentDirector());
        professorList.setPreferredSize(new Dimension(width * 1/10, height));
        professorList.setMaximumSize(new Dimension(width * 1/10, height));

        applyBtn = new JButton();
        cancelBtn = new JButton();

        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.getDepartmentDirectorField().setText(professorList.getSelectedValue());
                dialog.determineButtonActivity();
                dispose();

            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.determineButtonActivity();
                dispose();
            }
        });
        applyBtn.setText("Potvrdi");
        cancelBtn.setText("Odustani");

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(professorList);
        professorList.setLayoutOrientation(JList.VERTICAL);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) professorList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        add(pane);
        add(createBtnPanel());
    }

    private JPanel createBtnPanel() {
        JPanel btnPanel = new JPanel();
        BoxLayout box = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
        btnPanel.setLayout(box);
        applyBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("applyBtn"));
        cancelBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("cancelBtn"));
        btnPanel.add(applyBtn);
        btnPanel.add(cancelBtn);

        return btnPanel;
    }

    public JList getProfessorList(){
        return professorList;
    }
    
	public void initComponents() {
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("chooseDirector"));
		applyBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("applyBtn"));
		cancelBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("cancelBtn"));
	}
}
