package fr.fiegel.utils;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import fr.fiegel.objects.User;

public class Utils {

	public static final String USER_CO = "clientCo";

	public static Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	public static void setUserCo(User utilisateur) {
		getSession().put(USER_CO, utilisateur);
	}

	public static User getUserCo() {
		return (User) getSession().get(USER_CO);
	}

	public static void removeUserCo() {
		getSession().remove(USER_CO);
	}
	
	public static boolean isUserInSession(){
		return getSession().containsKey(USER_CO);
	}

}
