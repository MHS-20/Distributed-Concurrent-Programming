package pcd.lab05.mvc.version1_unresponsive;

public class TestGUI {
  static public void main(String[] args){
	  
	var model = new MyModel();
	var controller = new MyController(model);
    var view = new MyView(controller);
    model.addObserver(view);    
    view.display();
  }
  
}
