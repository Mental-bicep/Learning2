package userspkg;

public class UserMgmt {
	
	public void getUserInfo(String userType) {
		if(userType.equals("Retail")) System.out.println("Hey this is a Retial user");
		else if(userType.equals("Marketplace")) System.out.println("Hey this is a marketPlace user");
	}
	
}
