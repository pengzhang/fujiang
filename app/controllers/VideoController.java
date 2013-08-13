package controllers;

import java.util.List;
import java.util.Map;

import models.Video;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class VideoController extends Controller {

	public static Result get_video(long id,String act){
		Video v = Video.getVideo(id);
		if(act.equals("create")){
			//TODO 跳转video创建页面
			return ok();
		}
		//TODO 跳转video更新页面
		return ok();
	}
	
	public static Result upload_video(){
		return ok(upload_video.render());
	}
	
	public static Result create_video(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Video v = new Video();
		v.vtitle = map.get("vtitle");
		v.vdesc = map.get("vdesc");
		v.vurl = map.get("vurl");
		v.status = false;
		Video.createVideo(v);
		//TODO 跳转video列表页面
		return ok();
	}
	
	public static Result del_video(long id){
		Video.deleteVideo(id);
		//TODO 跳转video列表页面
		return ok();
	}
	
	public static Result update_video(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Video v = new Video();
		v.id = Long.parseLong(map.get("id"));
		v.vtitle = map.get("vtitle");
		v.vdesc = map.get("vdesc");
		v.vurl = map.get("vurl");
		Video.modifyVideo(v);
		//TODO 跳转video列表页面
		return ok();
	}
	
	public static Result status_video(long id){
		Video.statusVideo(id);
		//TODO 跳转video列表页面
		return ok();
	}
	
	public static Result list_video(){
		List<Video> vl = Video.getVideoList();
		//TODO 跳转video列表页面
		return ok();
	}
	

}
