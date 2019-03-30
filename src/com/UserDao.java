package com;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
	public List<User> getAllUsers(){ 

		List<User> userList = null; 
		try { 
			File file = new File("Users.dat"); 
			if (!file.exists()) { 
				User user1 = new User(1, "Mahesh", "BA"); 
				User user2 = new User(2, "Richa", "Developer");
				User user3 = new User(3, "Saurabh", "Developer");
				userList = new ArrayList<User>(); 
				userList.add(user1); 
				userList.add(user2); 
				userList.add(user3);
				saveUserList(userList); 
			} 
			else{ 
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				userList = (List<User>) ois.readObject(); 
				ois.close(); 
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}   
		return userList; 
	} 
	public User getUserById(int id) {
		List<User> userList = null; 
		User user1 = new User(1, "Jesus", "BA"); 
		User user2 = new User(2, "Richa", "Developer");
		User user3 = new User(3, "Saurabh", "Developer");
		userList = new ArrayList<User>(); 
		userList.add(user1); 
		userList.add(user2); 
		userList.add(user3);
		saveUserList(userList); 

		for(User u:userList) {
			if(u.getId() == id)
				return u;
		}
		return null;
	}

	public int addUser(User pUser){
		List<User> userList = getAllUsers();
		boolean userExists = false;
		for(User user: userList){
			if(user.getId() == pUser.getId()){
				userExists = true;
				break;
			}
		}		
		if(!userExists){
			userList.add(pUser);
			saveUserList(userList);
			return 1;
		}
		return 0;
	}

	public int updateUser(User pUser){
		List<User> userList = getAllUsers();

		for(User user: userList){
			if(user.getId() == pUser.getId()){
				int index = userList.indexOf(user);			
				userList.set(index, pUser);
				saveUserList(userList);
				return 1;
			}
		}		
		return 0;
	}

	public int deleteUser(int id){
		List<User> userList = getAllUsers();

		for(User user: userList){
			if(user.getId() == id){
				int index = userList.indexOf(user);			
				userList.remove(index);
				saveUserList(userList);
				return 1;   
			}
		}		
		return 0;
	}

	private void saveUserList(List<User> userList){ 
		try { 
			File file = new File("Users.dat"); 
			FileOutputStream fos;  
			fos = new FileOutputStream(file); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(userList); 
			oos.close(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}    
}
