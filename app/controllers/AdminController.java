package controllers;

import java.util.Map;

import models.Admin;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.*;

public class AdminController extends Controller {

	public static Result login() {

		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		String username = map.get("username");
		String password = map.get("password");
		if (Admin.login(username, password)) {
			session().put("username", username);
			return ok(index.render(""));
		}
		// TODO 跳转login页面
		return ok(login.render());
	}
	
	public static Result logout(){
		session().clear();
		return ok(login.render());
	}
	
}
