package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.Page;
import vo.S_C;

public interface ICourseDAO {
	//查询还未选的课
	public ArrayList<Course> querynoexit(@Param("course")Course course,@Param("page")Page page,@Param("SNO")String SNO,@Param("begin")int begin);
	//
	public ArrayList<Course> queryexit(@Param("course")Course course,@Param("page")Page page,@Param("SNO")String SNO,@Param("begin")int begin);
	//所有的课程查询功能
	public ArrayList<Course> queryAll(@Param("course")Course course,@Param("page")Page page,@Param("begin")int begin);	
	
    //数据的个数
	public ArrayList<Course> count(@Param("course")Course course,@Param("page")Page page,@Param("SNO")String SNO);
	
	public ArrayList<Course> excount(@Param("course")Course course,@Param("page")Page page,@Param("SNO")String SNO);
	
	public ArrayList<Course> classcount(@Param("course")Course course,@Param("page")Page page);
	
	//添加学生课表
	public boolean addclass(@Param("SNO")String SNO,@Param("CNO")String CNO);
	public boolean delclass(@Param("SNO")String SNO,@Param("CNO")String CNO);
	
	public S_C get(@Param("SNO")String SNO,@Param("CNO")String CNO);
	
	
	public ArrayList<S_C> teacherclassnum(@Param("course")Course course, @Param("page")Page page, @Param("begin")int begin);
	public ArrayList<S_C> teacherclassnumcount(@Param("course")Course course, @Param("page")Page page);
}
