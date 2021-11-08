package view;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		Button createEntity = new Button("Open dialog", "src/toolbar_imgs/open_dialog.png");
		add(createEntity);
		
		addSeparator();
		
		Button changeEntity = new Button("Change dialog", "src/toolbar_imgs/pen.png");
		add(changeEntity);
		
		addSeparator();
		
		
		Button removeEntity = new Button("Remove dialog", "src/toolbar_imgs/remove.png");
		add(removeEntity);
		
		add(Box.createHorizontalGlue());
		
		TextField searchInput = new TextField();
		add(searchInput);
		
		addSeparator();
		
		Button searchBtn = new Button("Search", "src/toolbar_imgs/search_icon.png");
		add(searchBtn);
		
		setFloatable(false);
		setBackground(new Color(48, 51, 49));
		
		
	}
}
