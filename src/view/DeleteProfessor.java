package view;

import javax.swing.JOptionPane;

public class DeleteProfessor extends JOptionPane{
	
    int response = showConfirmDialog(null, "Da li ste sigurni da zelite da obrisate profesora?", "Brisanje profesora",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

}
