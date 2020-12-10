package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.Page;
import vo.User;

public interface IUserMangerDAO {
	//查询所有的用户
	public ArrayList<User> query(@Param("user")User user,@Param("page")Page page,@Param("begin")int begin);
	//用户用例总条数
	public ArrayList<User> usercount(@Param("user")User user);
	//删除用户
	public boolean deleteuser(@Param("SNO")String SNO);
	
}
