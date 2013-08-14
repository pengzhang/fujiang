package controllers;

import java.util.List;

import models.Image;
import models.Message;
import models.Page;
import models.Question;
import models.Video;
import play.mvc.Controller;
import play.mvc.Result;
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
    	Video v = Video.getVideo();
    	return ok(video.render(v));
    }
    
    public static Result image(){
    	List<Image> il = Image.getImageList();
    	return ok(image.render(il));
    }
    
    public static Result message(){
    	List<Message> ml = Message.getMessageShow();
    	return ok(message.render(ml));
    }
    
    public static Result question(){
    	List<Question> ql = Question.getQuestionPage(0, 1);
    	Page pg = new Page();
    	pg.currentPage = 0;
    	pg.totalPage = Question.getQuestionTotalPage(1);
    	return ok(question.render(ql,pg));
    }
    
    public static Result success(){
    	return ok(success.render());
    }
  
}
