package dao;



import org.apache.ibatis.annotations.Param;

import vo.User;

public interface IUserDAO {
	//按用户名进行查询，返回User对象
	public User get( @Param("userName")String userName);
	public boolean updatapassword(@Param("password")String password,@Param("SNO")String SNO);
}
