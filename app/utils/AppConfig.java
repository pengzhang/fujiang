package utils;

import play.Play;


public class AppConfig {

	
	public static String Username = getConfig("username");
	
	public static String Password = getConfig("password");

	
			
	private static String getConfig(String config){
		return Play.application().configuration().getString(config);
	}
}
