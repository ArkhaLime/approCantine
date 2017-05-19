package fr.fiegel.objects;

public class User {

	protected int ident;
	protected String name;
	protected String forname;
	protected String email;
	protected String password;
	
	public User(){}
	
	public User(int ident,String name, String forname,String email, String password){
		this.ident=ident;
		this.name=name;
		this.forname=forname;
		this.email=email;
		this.password=password;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ident=" + ident + ", name=" + name + ", forname=" + forname + ", email=" + email + "]";
	}
	
}
