package service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import service.IUserService;
import vo.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDao;
	@Override
	public User get(String userName) {
		// TODO Auto-generated method stub
		return userDao.get(userName);
	}
	
	
	@Override
	public Map<String, Object> checkLogin(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String,Object>();
		User userResult=userDao.get(user.getUserName());
		if(userResult == null){
			map.put("code", 2);
			map.put("info", "用户名不存在");
		}
		else{
			if(userResult.getPassword().equals(user.getPassword())){
				//map.put("code", 0);
				if(userResult.getRole().equals("user"))
				{
					map.put("info", "登录成功");
					map.put("code", 0);
				}
				else if(userResult.getRole().equals("manger"))
				{
					map.put("info", "登录成功");
					map.put("code", 4);
				}
				else {
					map.put("info", "登录成功");
					map.put("code", 5);
				}
			}
			else{
				map.put("code", 3);
				map.put("info", "密码不正确");
			}
		}
		return map;
	}


	@Override
	public boolean updatapassword(String password,String SNO) {
		// TODO 自动生成的方法存根
		return userDao.updatapassword(password,SNO);
	}


}
