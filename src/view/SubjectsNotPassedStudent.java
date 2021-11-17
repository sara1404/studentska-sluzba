package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SubjectsNotPassedStudent extends JPanel{
	public SubjectsNotPassedStudent() {
		JPanel buttonPanel = new JPanel();
		BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box);
		
		JButton addBtn = new JButton();
		JButton removeBtn = new JButton();
		JButton passBtn = new JButton();
		
		addBtn.setText("Dodaj");
		removeBtn.setText("Obrisi");
		passBtn.setText("Polaganje");
		
		WindowComponentBuilder.setContainerSize(addBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(removeBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(passBtn, 100, 30);
		
		Utils.setCursor(addBtn);
		Utils.setCursor(removeBtn);
		Utils.setCursor(passBtn);
		
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.add(passBtn);
		
		add(buttonPanel);
	}
	
	
}
