package models;

import utils.AppConfig;

public class Admin {
	
	public static boolean login(String username,String password){
		if(username.equals(AppConfig.Username) && password.equals(AppConfig.Password)){
			return true;
		}
		return false;
	}

}
