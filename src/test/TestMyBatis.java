package test;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import service.IClassMangerService;
import service.ICourseService;
import service.IScoreService;
import service.IUserMangerService;
import service.IUserService;
import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;



//让测试在Spring容器环境下执行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	

	
	private static Logger log = LogManager.getLogger(Test.class.getName());


	@Autowired
	private IUserService userservice;
	@Autowired
	private IScoreService scoreservice;
	@Autowired
	private ICourseService coursedao;
	@Autowired
	private IUserMangerService mangerdao;
	
	@Autowired
	private IClassMangerService classdao;
	@Test
	public void test2() {
//		User user=new User(null,null,null,null,null);
		Page page =new Page(5,1,"SNO","asc");
		int begin=0;
		Course course=new Course();
		ArrayList<S_C> list=coursedao.teacherclassnum(course, page, begin);
		ArrayList<S_C> list1=coursedao.teacherclassnumcount(course, page);
		System.out.println(list);
		System.out.println(list1.size());
//		Course course=new Course();
//		course=classdao.get("1");
//		System.out.println(course);
//		
//		boolean success=scoreservice.updateclass("12", "6", "80");
//		System.out.println(success);
		
//		S_C s=new S_C();
//		s=coursedao.get("12", "6");
//		System.out.println(s);
		
		
		
	}

}
	
	
