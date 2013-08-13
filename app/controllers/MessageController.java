package controllers;

import java.util.List;
import java.util.Map;

import models.Message;
import models.Question;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

public class MessageController extends Controller {

	public static Result get_message(long id){
		Message msg = Message.getMessage(id);
		//TODO 跳转message更新页面
		return ok();
	}
	
	public static Result create_message(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Message msg = new Message();
		msg.email = map.get("email");
		msg.message = map.get("message");
		msg.mobile = map.get("mobile");
		msg.name = map.get("name");
		Message.createMessage(msg);
		//TODO 跳转message列表页面
		return ok();
	}
	
	public static Result del_message(long id){
		Question.deleteQuestion(id);
		//TODO 跳转message列表页面
		return ok();
	}
	
	public static Result update_message(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Message msg = new Message();
		msg.email = map.get("email");
		msg.message = map.get("message");
		msg.mobile = map.get("mobile");
		msg.name = map.get("name");
		Message.modifyMessage(msg);
		//TODO 跳转message列表页面
		return ok();
	}
	
	public static Result status_message(long id){
		Message.statusMessage(id);
		//TODO 跳转message列表页面
		return ok();
	}
	
	public static Result list_message(){
		List<Message> ml = Message.getMessageList();
		//TODO 跳转message列表页面
		return ok();
	}
	

}
