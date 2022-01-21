package view.dialogs;

import bundle.LanguageSupport;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HelpDialog extends JDialog {
    public HelpDialog(){
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addStudDialogTitle"));
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);
        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1/2, height * 4/5);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JTextArea area = new JTextArea(40, 65);
        area.setLineWrap(true);
        area.setText(LanguageSupport.getInstance().getResourceBundle().getString("help-text"));
        area.setEditable(false);
        panel.add(new JScrollPane(area));
        add(panel);
    }


}
