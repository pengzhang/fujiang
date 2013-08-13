package controllers;

import java.util.List;
import java.util.Map;

import models.Image;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

public class ImageController extends Controller {

	public static Result get_image(long id,String act){
		Image img = Image.getImage(id);
		if(act.equals("create")){
			//TODO 跳转image创建页面
			return ok();
		}
		//TODO 跳转image更新页面
		return ok();
	}
	
	public static Result create_image(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Image img = new Image();
		img.ititle = map.get("ititle");
		img.iurl = map.get("iurl");
		Image.createImage(img);
		//TODO 跳转image列表页面
		return ok();
	}
	
	public static Result del_image(long id){
		Image.deleteImage(id);
		//TODO 跳转image列表页面
		return ok();
	}
	
	public static Result update_image(){
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Image img = new Image();
		img.id = Long.parseLong(map.get("id"));
		img.ititle = map.get("ititle");
		img.iurl = map.get("iurl");
		Image.modifyImage(img);
		//TODO 跳转image列表页面
		return ok();
	}
	
	public static Result list_image(){
		List<Image> il = Image.getImageList();
		//TODO 跳转image列表页面
		return ok();
	}
	

}
