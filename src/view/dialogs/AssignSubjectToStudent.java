package view.dialogs;

import model.*;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignSubjectToStudent extends JDialog {
    private JList<String> subjectList;
    private JButton applyBtn;
    private JButton cancelBtn;
    private AssignSubjectToStudent ctx = this;
    public AssignSubjectToStudent() {
        setModalityType(DEFAULT_MODALITY_TYPE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle("Dodavanje predmeta");
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1/4, height * 1/3);
        setLocationRelativeTo(null);

        applyBtn = new JButton();
        cancelBtn = new JButton();

        Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
        CustomListModelForNotPassedSubjects customListModelForNotPassedSubjects = new CustomListModelForNotPassedSubjects(student);
        subjectList = new JList<>(customListModelForNotPassedSubjects);
        subjectList.setPreferredSize(new Dimension(width * 1/10, height));
        subjectList.setMaximumSize(new Dimension(width * 1/10, height));

        applyBtn.setText("Potvrdi");
        cancelBtn.setText("Odustani");
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(subjectList);
        subjectList.setLayoutOrientation(JList.VERTICAL);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) subjectList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        add(pane);
        add(createBtnPanel());
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctx.dispose();
            }
        });

        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subjectList.getSelectedIndex() == -1) {
                    System.out.println("nije selektovan element");
                    ctx.dispose();
                    return;
                }
                student.getFailedExams().add(customListModelForNotPassedSubjects.getSubjectElement(subjectList.getSelectedIndex()));
                ObserverNotifier.getInstance().subjectsNotPassedDataChanged();
                ctx.dispose();
            }
        });
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

    public JList<String> getSubjectList() {
        return subjectList;
    }

    public JButton getApplyBtn() {
        return applyBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }
}
