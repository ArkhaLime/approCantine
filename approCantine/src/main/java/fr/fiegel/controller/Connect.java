package fr.fiegel.controller;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import fr.fiegel.dao.UserDAO;
import fr.fiegel.objects.User;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class Connect extends ActionSupport {

	private User userCo=null;
	private String userEmail;
	private String userPwd;
	
	public Connect() {
		super();
		System.out.println("Instanciation Connect");
		// TODO Auto-generated constructor stub
	}
	
	public String login(){
		System.out.println("Appel méthode 'login'");
		UserDAO uDao = new UserDAO();
		try {
			userCo=uDao.connect(userEmail, userPwd);
			if(userCo==null){
				return "CO-ERROR";
			}
			Utils.setUserCo(userCo);
			return "CO-SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILED";
		}
	}

	public User getUserCo() {
		return userCo;
	}

	public void setUserCo(User userCo) {
		this.userCo = userCo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	

}
