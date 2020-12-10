package service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Page;
import vo.User;

public interface IUserMangerService {
	public ArrayList<User> query(User user,Page page,int begin);
	public ArrayList<User> usercount(User user);
	public boolean deleteuser(String SNO);
	

}
