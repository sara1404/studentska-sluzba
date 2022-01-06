package controller;

public class ShowNotPassedExamsController {
	private static ShowNotPassedExamsController instance = null;

    private ShowNotPassedExamsController(){}
    
    public static ShowNotPassedExamsController getInstance(){
        if(instance == null)
            instance = new ShowNotPassedExamsController();
        return instance;
    }
    
    
    

}
