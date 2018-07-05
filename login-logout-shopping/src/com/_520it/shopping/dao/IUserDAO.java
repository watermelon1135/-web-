package com._520it.shopping.dao;


import com._520it.shopping.domain.User;

public interface IUserDAO {
		User getUserByUsername(String username);
		void save(User user);
}
