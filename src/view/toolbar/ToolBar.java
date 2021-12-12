package view.toolbar;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ListenerController;
import view.listeners.ToolbarListener;

public class ToolBar extends JToolBar {
	Button createEntityBtn;
	Button changeEntityBtn;
	Button removeEntityBtn;
	Button searchBtn;
	
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		ToolbarListener tlNew = new ToolbarListener(KeyEvent.VK_N);
		ToolbarListener tlChange = new ToolbarListener(KeyEvent.VK_E);
		ToolbarListener tlDelete = new ToolbarListener(KeyEvent.VK_DELETE);
		ToolbarListener tlSearch = new ToolbarListener(KeyEvent.VK_S);

		createEntityBtn = new Button("Open entity", "src/toolbar_imgs/open_dialog.png", tlNew);
		
		add(createEntityBtn);
		
		addSeparator();
		
		changeEntityBtn = new Button("Change entity", "src/toolbar_imgs/pen.png", tlChange);
		add(changeEntityBtn);

		
		addSeparator();
		

		removeEntityBtn = new Button("Remove entity", "src/toolbar_imgs/remove.png", tlDelete);
		add(removeEntityBtn);

		add(Box.createHorizontalGlue());
		
		TextField searchInput = new TextField();
		add(searchInput);
		
		addSeparator();
		
		searchBtn = new Button("Search", "src/toolbar_imgs/search_icon.png", tlSearch);
		add(searchBtn);
		
		setFloatable(false);
		setBackground(new Color(48, 51, 49));
		
	}
	
	public Button getCreateEntityBtn() {
		return createEntityBtn;
	}
	
	public Button getChangeEntityBtn() {
		return changeEntityBtn;
	}
	
	public Button getRemoveEntityBtn() {
		return removeEntityBtn;
	}
	
	public Button getSearchBtn() {
		return searchBtn;
	}
}
