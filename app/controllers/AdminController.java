package controllers;

import java.util.Map;

import models.Admin;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

public class AdminController extends Controller {

	public static Result login() {

		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		String username = map.get("username");
		String password = map.get("password");
		if (Admin.login(username, password)) {
			// TODO 跳转Admin页面
			session().put("username", username);
			return ok();
		}
		// TODO 跳转login页面
		return ok();
	}
	
}
