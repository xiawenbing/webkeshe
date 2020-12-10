package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICourseDAO;
import dao.IUserDAO;
import service.ICourseService;
import vo.Course;
import vo.Page;
import vo.S_C;
@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private ICourseDAO coursedao;
	@Override
	public ArrayList<Course> querynoexit(Course course, Page page, String SNO,int begin) {
		// TODO 自动生成的方法存根
		return coursedao.querynoexit(course, page, SNO,begin);
	}
	
	@Override
	public ArrayList<Course> queryAll(Course course, Page page,int begin) {
		// TODO 自动生成的方法存根
		return coursedao.queryAll(course,page,begin);
	}
	@Override
	public ArrayList<Course> queryexit(Course course, Page page, String SNO,int begin) {
		// TODO 自动生成的方法存根
		return coursedao.queryexit(course, page, SNO,begin);
	}

	
	@Override
	public ArrayList<Course> count(Course course, Page page, String SNO) {
		// TODO 自动生成的方法存根
		return coursedao.count(course, page, SNO);
	}

	@Override
	public ArrayList<Course> excount(Course course, Page page, String SNO) {
		// TODO 自动生成的方法存根
		return coursedao.excount(course, page, SNO);
	}

	@Override
	public ArrayList<Course> classcount(Course course, Page page) {
		// TODO 自动生成的方法存根
		return coursedao.classcount(course, page);
	}

	@Override
	public boolean addclass(String SNO, String CNO) {
		// TODO 自动生成的方法存根
		return coursedao.addclass(SNO, CNO);
	}

	@Override
	public boolean delclass(String SNO, String CNO) {
		// TODO 自动生成的方法存根
		return coursedao.delclass(SNO, CNO);
	}

	@Override
	public S_C get(String SNO, String CNO) {
		// TODO 自动生成的方法存根
		return coursedao.get(SNO, CNO);
	}

	@Override
	public ArrayList<S_C> teacherclassnum(Course course, Page page, int begin) {
		// TODO 自动生成的方法存根
		return coursedao.teacherclassnum(course, page, begin);
	}

	@Override
	public ArrayList<S_C> teacherclassnumcount(Course course, Page page) {
		// TODO 自动生成的方法存根
		return coursedao.teacherclassnumcount(course, page);
	}

}
