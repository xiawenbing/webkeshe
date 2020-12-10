package service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICourseDAO;
import dao.IScoreDAO;
import service.IScoreService;
import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;
@Service
public class ScoreServiceImpl implements IScoreService {

	@Autowired
	private IScoreDAO scoredao;
	@Override
	public ArrayList<S_C> Score(User user, Page page, int begin) {
		// TODO 自动生成的方法存根
		return scoredao.Score(user, page, begin);
	}
	@Override
	public ArrayList<S_C> scorecount(User user, Page page) {
		// TODO 自动生成的方法存根
		return scoredao.scorecount(user,page);
	}
	@Override
	public ArrayList<S_C> teacherclass(User user, Page page, int begin) {
		// TODO 自动生成的方法存根
		return scoredao.teacherclass(user, page, begin);
	}
	@Override
	public ArrayList<S_C> teachercount(User user, Page page) {
		// TODO 自动生成的方法存根
		return scoredao.teachercount(user, page);
	}
	@Override
	public boolean updateclass(String SNO, String CNO, String Score) {
		// TODO 自动生成的方法存根
		return scoredao.updatescore(SNO,CNO,Score);
	}
	@Override
	public boolean insertclass(String SNO, String CNO, String Score) {
		// TODO 自动生成的方法存根
		return scoredao.insertclass(SNO,CNO,Score);
	}

}
