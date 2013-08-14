package utils;

import play.Play;


public class AppConfig {

	
	public static String Username = getConfig("username");
	
	public static String Password = getConfig("password");
	
	public static String ImagePath = getConfig("image.path");
	
	public static String VideoPath = getConfig("video.path");
	
	public static String SystemUrl = getConfig("system.url");
			
	private static String getConfig(String config){
		return Play.application().configuration().getString(config);
	}
}
