package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="image")
public class Image extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	public long id;
	@Column
	public String ititle;
	@Column
	public String iurl;
	
	public static Model.Finder<Long, Image> find = new Model.Finder<Long, Image>(Long.class, Image.class);
	
	public static void createImage(Image i){
		i.save();
	}
	
	public static void modifyImage(Image i){
		i.update();
	}
	
	public static void deleteImage(long id){
		find.byId(id).delete();
	}
	
	public static Image getImage(long id){
		return find.byId(id);
	}
	
	public static List<Image> getImageList(){
		return find.all();
	}
	
	public static List<Image> getImagePage(int page,int size){
		return find.findPagingList(size).getPage(page).getList();
	}
	
	public static int getImageTotalPage(int size){
		return find.findPagingList(size).getTotalPageCount();
	}

}
