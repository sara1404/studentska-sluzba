package view.dialogs;

import bundle.LanguageSupport;
import controller.SetDepartmentDirectorController;
import model.CustomListModelForDepartmentProfessors;
import model.CustomListModelForSubjectListProfessor;
import model.Professor;
import utils.WindowComponentBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProfessorToDepartmentDialog extends JDialog{
    private JList list;
    private JButton addBtn;
    private JButton cancelBtn;
    private AddProfessorToDepartmentDialog ctx = this;
    public AddProfessorToDepartmentDialog() {
        setModalityType(DEFAULT_MODALITY_TYPE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addProfDialog"));
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1 / 4, height * 1 / 3);
        setLocationRelativeTo(null);
        addBtn = new JButton();
        cancelBtn = new JButton();
        CustomListModelForDepartmentProfessors customListModelForDepartmentProfessors = new CustomListModelForDepartmentProfessors();
        list = new JList<>(customListModelForDepartmentProfessors);
        list.setPreferredSize(new Dimension(width * 1/10, height));
        list.setMaximumSize(new Dimension(width * 1/10, height));

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        add(pane);
        add(WindowComponentBuilder.createButtons(addBtn, cancelBtn));

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetDepartmentDirectorController.getInstance().addProfessorToDepartment(ctx);
                dispose();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public JList<CustomListModelForDepartmentProfessors> getList() {
        return list;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }
}
