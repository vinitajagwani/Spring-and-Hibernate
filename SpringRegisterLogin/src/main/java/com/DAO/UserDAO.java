package com.DAO;
import com.user.User;
public interface UserDAO {
	public int registerUser(User user);
	public String loginUser(User user);
}
