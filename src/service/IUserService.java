package service;

import java.util.Map;

import vo.User;

public interface IUserService {
	public User get(String userName);
	public Map<String,Object> checkLogin(User user);
	public boolean updatapassword(String password,String SNO);
}
