package com.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import com.user.User;

public class UserDAOImplementation implements UserDAO{

	private JdbcTemplate jdbcTemplate;
	public UserDAOImplementation(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public int registerUser(User user) {
		String sql="insert into user values(?,?)";
		try {
			int counter=jdbcTemplate.update(sql, new Object[] {
					user.getUserName(),user.getPassword()}
			);
			return counter;
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public String loginUser(User user) {
		String sql="select userName from user where userName=? and password=?";
		try {
			String userName=jdbcTemplate.queryForObject(sql, new Object[] 
					{user.getUserName(),user.getPassword()},String.class);
			return userName;
		} catch (Exception e) {
			return null;
		}
		
	}

}
