package com._520it.shopping.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T> {
	T Handler(ResultSet rs) throws  SQLException;
}
