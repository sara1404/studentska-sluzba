package bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSupport {
	private static LanguageSupport instance;
	private ResourceBundle resourceBundle;
	
	private LanguageSupport() {
		Locale.setDefault(new Locale("sr", "RS"));
//		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	}
	
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}




	public static LanguageSupport getInstance() {
		if(instance == null)
			instance = new LanguageSupport();
		return instance;
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	}
}
