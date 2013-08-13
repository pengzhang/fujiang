package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import models.Image;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import utils.AppConfig;
import views.html.*;

public class ImageController extends Controller {

	public static Result get_image(long id, String act) {
		Image img = Image.getImage(id);
		if (act.equals("create")) {
			// TODO 跳转image创建页面
			return ok();
		}
		// TODO 跳转image更新页面
		return ok();
	}

	public static Result upload_image() {
		return ok(upload_image.render());
	}

	public static Result create_image() {

		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Image img = new Image();
		img.ititle = map.get("ititle");
		img.iurl = map.get("iurl");
		Logger.info("Image:" + Json.toJson(img).toString());

		MultipartFormData body = request().body().asMultipartFormData();
		FilePart picture = body.getFile("picture");
		if (picture != null) {
			String fileName = picture.getFilename();
			String contentType = picture.getContentType();
			File file = picture.getFile();
			Logger.info("Image File:" + fileName + ";" + contentType);
			
			String local = AppConfig.ImagePath + fileName;
			File file_local = new File("public/" + local);
			try {
				FileUtils.copyFile(file, file_local);
			} catch (IOException e) {
				Logger.info("Image File Save Errro!");
				e.printStackTrace();
			}
			img.iurl= "/assets/"+ local;
			Image.createImage(img);
			return redirect("/image/list");
		} else {
			return redirect("/image/upload");
		}

	}

	public static Result del_image(long id) {
		Image.deleteImage(id);
		return redirect("/image/list");
	}

	public static Result update_image() {
		Map<String, String> map = DynamicForm.form().bindFromRequest().data();
		Image img = new Image();
		img.id = Long.parseLong(map.get("id"));
		img.ititle = map.get("ititle");
		img.iurl = map.get("iurl");
		Image.modifyImage(img);
		// TODO 跳转image列表页面
		return ok();
	}

	public static Result list_image() {
		List<Image> il = Image.getImageList();
		return ok(image_mgr.render(il));
	}

}
