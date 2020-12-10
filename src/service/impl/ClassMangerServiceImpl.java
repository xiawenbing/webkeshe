package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IClassMangerDAO;
import dao.ICourseDAO;
import service.IClassMangerService;
import vo.Course;
@Service
public class ClassMangerServiceImpl implements IClassMangerService {
	@Autowired
	private IClassMangerDAO classdao;
	@Override
	public boolean insertclass(String CNO, String CName, String Point) {
		// TODO 自动生成的方法存根
		return classdao.insertclass(CNO, CName, Point);
	}
	@Override
	public boolean deletclass(String CNO) {
		// TODO 自动生成的方法存根
		return classdao.deletclass(CNO);
	}
	@Override
	public Course get(String CNO) {
		// TODO 自动生成的方法存根
		return classdao.get(CNO);
	}
	@Override
	public boolean updatecalss(String Point, String CNO) {
		// TODO 自动生成的方法存根
		return classdao.updatecalss(Point, CNO);
	}
	
}
