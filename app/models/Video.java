package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="video")
public class Video extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	public long id;
	@Column
	public String vtitle;
	@Column
	public String vdesc;
	@Column
	public String vurl;
	@Column
	public boolean status;
	
	public static Model.Finder<Long, Video> find = new Model.Finder<Long, Video>(Long.class, Video.class);
	
	public static void createVideo(Video v){
		v.save();
	}
	
	public static void modifyVideo(Video v){
		v.update();
	}
	
	public static void deleteVideo(long id){
		find.byId(id).delete();
	}
	
	public static Video getVideo(){
		return find.where().eq("status", true).findUnique();
	}
	
	public static Video getVideo(long id){
		return find.byId(id);
	}
	
	public static List<Video> getVideoList(){
		return find.all();
	}
	
	public static void statusVideo(long id){
		for(Video v : find.all()){
			v.status = false;
			v.update();
		}
		Video vd = find.byId(id);
		vd.status = true;
		vd.update();
	}
	
	public static List<Video> getVideoPage(int page,int size){
		return find.findPagingList(size).getPage(page).getList();
	}
	
	public static int getVideoTotalPage(int size){
		return find.findPagingList(size).getTotalPageCount();
	}

}
