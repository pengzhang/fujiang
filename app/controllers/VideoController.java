package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import models.Video;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import utils.AppConfig;
import views.html.*;

public class VideoController extends Controller {

	public static Result get_video(long id,String act){
//		Video v = Video.getVideo(id);
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
		
		v.status = false;
		
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart video = body.getFile("video");
		if (video != null) {
			String fileName = video.getFilename();
			String contentType = video.getContentType();
			File file = video.getFile();
			Logger.info("Video File:" + fileName + ";" + contentType);
			
			String local = AppConfig.VideoPath + fileName;
			File file_local = new File("public/" + local);
			try {
				FileUtils.copyFile(file, file_local);
			} catch (IOException e) {
				Logger.info("Video File Save Errro!");
				e.printStackTrace();
			}
			v.vurl= "/assets/"+ local;
			Video.createVideo(v);
			return redirect("/video/list");
		} else {
			return redirect("/video/upload");
		}
		
		
	}
	
	public static Result del_video(long id){
		Video.deleteVideo(id);
		return redirect("/video/list");
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
		return redirect("/video/list");
	}
	
	public static Result list_video(){
		List<Video> vl = Video.getVideoList();
		return ok(video_mgr.render(vl));
	}
	

}
