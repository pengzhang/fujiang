package controllers;

import java.util.List;

import models.Image;
import models.Message;
import models.Question;
import models.Video;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result login(){
    	if(session().get("username") != null){
    		return redirect("/video/list");
    	}
    	return ok(login.render());
    }
    
    public static Result video(){
//    	Video v = Video.getVideo();
    	//TODO 跳转video页面
    	return ok(video.render());
    }
    
    public static Result image(){
    	List<Image> il = Image.getImageList();
    	return ok(image.render(il));
    }
    
    public static Result message(){
//    	List<Message> ml = Message.getMessageShow();
    	//TODO 跳转到message页面
    	return ok(message.render());
    }
    
    public static Result question(){
//    	List<Question> ql = Question.getQuestionList();
    	//TODO 跳转到question页面
    	return ok(question.render());
    }
  
}
