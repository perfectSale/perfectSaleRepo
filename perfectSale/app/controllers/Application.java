package controllers;

import com.google.inject.Inject;

import play.*;
import play.libs.ws.WSClient;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {


	 
    public Result index() {
        return ok(pageNotFound.render());
    }
    
  
    

}
