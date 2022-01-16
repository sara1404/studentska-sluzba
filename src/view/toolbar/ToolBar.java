package view.toolbar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import bundle.LanguageSupport;
import controller.ListenerController;
import controller.SearchController;
import view.listeners.ToolbarListener;

public class ToolBar extends JToolBar {
	private Button createEntityBtn;
	private Button changeEntityBtn;
	private Button removeEntityBtn;
	private Button searchBtn;
	private JTextField searchField;
	
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		ToolbarListener tlNew = new ToolbarListener(KeyEvent.VK_N);
		ToolbarListener tlChange = new ToolbarListener(KeyEvent.VK_E);
		ToolbarListener tlDelete = new ToolbarListener(KeyEvent.VK_DELETE);
		ToolbarListener tlSearch = new ToolbarListener(KeyEvent.VK_S);

		createEntityBtn = new Button(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip1"), "src/toolbar_imgs/open_dialog.png", tlNew);
		
		add(createEntityBtn);
		
		addSeparator();
		
		changeEntityBtn = new Button(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip2"), "src/toolbar_imgs/pen.png", tlChange);
		add(changeEntityBtn);

		
		addSeparator();
		

		removeEntityBtn = new Button(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip3"), "src/toolbar_imgs/remove.png", tlDelete);
		add(removeEntityBtn);

		add(Box.createHorizontalGlue());
		
		searchField = new TextField();
		add(searchField);
		
		addSeparator();
		
		searchBtn = new Button(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip4"), "src/toolbar_imgs/search_icon.png", tlSearch);
		add(searchBtn);

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchController.getInstance().search();
			}
		});
		
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
	public JTextField getSearchField() {
		return searchField;
	}
	
	public void initComponents() {
		createEntityBtn.setToolTipText(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip1"));
		changeEntityBtn.setToolTipText(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip2"));
		removeEntityBtn.setToolTipText(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip3"));
		searchBtn.setToolTipText(LanguageSupport.getInstance().getResourceBundle().getString("toolbarTip4"));
	}
}
