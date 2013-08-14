package controllers;

import java.util.List;
import java.util.Map;

import models.Page;
import models.Question;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class QuestionController extends Controller {

	public static Result get_question(long id,String act){
//		Question q = Question.getQuestion(id);
		if(act.equals("create")){
			//TODO 跳转question创建页面
			return ok();
		}
		//TODO 跳转question更新页面
		return ok();
	}
	
	public static Result upload_question(){
		return ok(upload_question.render());
	}
	
	public static Result create_question(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Question q = new Question();
		q.qtitle = map.get("qtitle");
		q.qoptionA = map.get("qoptionA");
		q.qoptionB = map.get("qoptionB");
		q.qoptionC = map.get("qoptionC");
		q.qoptionD = map.get("qoptionD");
		q.right = map.get("right");
		Question.createQuestion(q);
		return redirect("/question/list");
	}
	
	public static Result del_question(long id){
		Question.deleteQuestion(id);
		return redirect("/question/list");
	}
	
	public static Result update_question(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Question q = new Question();
		q.id = Long.parseLong(map.get("id"));
		q.qtitle = map.get("qtitle");
		q.qoptionA = map.get("qoptionA");
		q.qoptionB = map.get("qoptionB");
		q.qoptionC = map.get("qoptionC");
		q.qoptionD = map.get("qoptionD");
		q.right = map.get("right");
		Question.modifyQuestion(q);
		//TODO 跳转question列表页面
		return ok();
	}
	
	public static Result list_question(){
		List<Question> ql = Question.getQuestionList();
		return ok(question_mgr.render(ql));
	}
	
	public static Result page_question(int page,int size){
		List<Question> ql = Question.getQuestionPage(page, size);
		Page pg = new Page();
		pg.currentPage = page;
		pg.totalPage = Question.getQuestionTotalPage(size);
		return ok(question.render(ql,pg));
	}
	

}
