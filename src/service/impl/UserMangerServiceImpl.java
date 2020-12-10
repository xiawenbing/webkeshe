package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICourseDAO;
import dao.IUserMangerDAO;
import service.IUserMangerService;
import vo.Page;
import vo.User;

@Service
public class UserMangerServiceImpl implements IUserMangerService {
	
	@Autowired
	private IUserMangerDAO mangerdao;

	@Override
	public ArrayList<User> query(User user, Page page, int begin) {
		// TODO 自动生成的方法存根
		return mangerdao.query(user, page, begin);
	}

	@Override
	public ArrayList<User> usercount(User user) {
		// TODO 自动生成的方法存根
		return mangerdao.usercount(user);
	}

	@Override
	public boolean deleteuser(String SNO) {
		// TODO 自动生成的方法存根
		return mangerdao.deleteuser(SNO);
	}
}
