package service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.Page;
import vo.S_C;

public interface ICourseService {
	public ArrayList<Course> querynoexit(Course course,Page page,String SNO,int begin);
	public ArrayList<Course> queryexit(Course course,Page page,String SNO,int begin);
	public ArrayList<Course> queryAll(Course course,Page page,int begin);
	
	public ArrayList<Course> count(Course course,Page page,String SNO);
	public ArrayList<Course> excount(Course course,Page page,String SNO);
	public ArrayList<Course> classcount(Course course,Page page);
	public boolean addclass(String SNO,String CNO);
	public boolean delclass(String SNO,String CNO);
	public S_C get(@Param("SNO")String SNO,@Param("CNO")String CNO);
	
	public ArrayList<S_C> teacherclassnum(Course course, Page page, int begin);
	public ArrayList<S_C> teacherclassnumcount(Course course, Page page);

}
