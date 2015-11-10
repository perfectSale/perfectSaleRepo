import com.google.inject.Inject;

import play.*;
import play.api.mvc.Handler;
import play.libs.F.Promise;
import play.libs.ws.WSClient;
import play.mvc.*;
import views.html.pageNotFound;
import static play.mvc.Results.*;




public class Global extends GlobalSettings  {
	

	
	
	 @Override
	  public void onStart(Application app) {
	    Logger.info("Application has started");
	  }  
	  
	  @Override
	  public void onStop(Application app) {
	    Logger.info("Application shutdown...");
	  } 
	  

	   @Override
	    public Promise<Result> onBadRequest(Http.RequestHeader request, java.lang.String error) {
	        Logger.info("onBadRequest");
	        return Promise.<Result>pure(badRequest("Don't try to hack the URI!"));
	      
	    }
	  
	    @Override
	   public Promise<Result> onError(Http.RequestHeader request, java.lang.Throwable t){
		   Logger.info("onError");
		   return Promise.<Result>pure(notFound(
		             views.html.pageNotFound.render()
		         ));
		   
	   }
	
	 @Override
      public Promise<Result> onHandlerNotFound(Http.RequestHeader request){
	     Logger.info("onHandlerNotFound");	          
	    
	     return Promise.<Result>pure(notFound(
	             views.html.pageNotFound.render()
	         ));

	   }
	   
	   
	  @Override
       public  Action onRequest(Http.Request request, java.lang.reflect.Method actionMethod){
	  	    	     System.out.println("onRequest");	  	  
	  	    		  return super.onRequest(request, actionMethod);  
	  	    		  
      }
	  	    	        @Override
	public Handler onRouteRequest(Http.RequestHeader request){
	  	    	        	
		   Logger.info("onRouteRequest"+ request.uri());
		return null;
	   }

}
