package view.dialogs;

import model.CustomListModelForDepartmentDirector;
import model.CustomListModelForProfessors;
import model.DatabaseReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignProfessorToDepartmentDirectorDialog extends JDialog {
    JList<String> professorList;
    JButton applyBtn;
    JButton cancelBtn;
    public AssignProfessorToDepartmentDirectorDialog(AddDepartmentDirectorDialog dialog){
        setModalityType(DEFAULT_MODALITY_TYPE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle("Odaberi sefa katedre");
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
                dispose();

            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        applyBtn.setText("Potvrdi");
        cancelBtn.setText("Odustani");
        btnPanel.add(applyBtn);
        btnPanel.add(cancelBtn);

        return btnPanel;
    }

    public JList getProfessorList(){
        return professorList;
    }
}
