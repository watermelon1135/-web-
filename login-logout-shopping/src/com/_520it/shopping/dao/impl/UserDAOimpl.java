package com._520it.shopping.dao.impl;

import com._520it.shopping.dao.IUserDAO;
import com._520it.shopping.domain.User;
import com._520it.shopping.handler.ResultSetHandler;
import com._520it.shopping.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOimpl implements IUserDAO {

	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM t_user WHERE username=?";
		return JdbcTemplate.query(sql, new ResultSetHandler<User>() {
			public User Handler(ResultSet rs) throws SQLException {
				if (rs.next()){
					User u = new User();
					u.setId(rs.getLong("id"));
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					return u;
				}
				return null;
			}
		},username);
	}

	@Override
	public void save(User user) {
		String sql = "insert into t_user(username,password) values(?,?);";
		JdbcTemplate.update(sql,user.getUsername(),user.getPassword());
	}

}
