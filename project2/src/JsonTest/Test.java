package JsonTest;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

	String userJson = "[{'name': 'Alex','id': 1}, " + "{'name': 'Brian','id':2}, " + "{'name': 'Charles','id': 3}]";

	Gson gson = new Gson();
	User[] userArray = gson.fromJson(userJson, User[].class);  
	System.out.println(userArray);
	for(User user:userArray){
		System.out.println(user);
	}
}
}