package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SubjectsListProfessor extends JPanel{
	
		public SubjectsListProfessor() {
			JPanel pan = new JPanel();
			BoxLayout box = new BoxLayout(pan, BoxLayout.X_AXIS);
			pan.setLayout(box);
			
			JButton addBtn  = new JButton();
			addBtn.setText("Dodaj");
			Utils.setCursor(addBtn);
			pan.add(addBtn);
			
			
			
			JButton removeBtn = new JButton();
			removeBtn.setText("Obrisi");
			pan.add(removeBtn);
			Utils.setCursor(removeBtn);
			
			
			
			add(pan);
		}

}
