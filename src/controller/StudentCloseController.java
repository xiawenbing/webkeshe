package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ICourseService;
import service.IUserService;
import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;

@Controller
public class StudentCloseController {
	
	@Autowired
	private  ICourseService courseService;
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/StudentClose.do", method = RequestMethod.POST)
	@ResponseBody
	public String StudentClose(String queryParams,String pageParams,
			HttpSession session, HttpServletResponse response)
	{	
		String SNO=(String) session.getAttribute("SNO");	
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String, Object> mapPage = gson.fromJson(pageParams, HashMap.class);
		Page page = new Page();
		page = page.getByHashMap(mapPage); 
		Course course=new Course();
		if(queryParams!=null) {
			course = gson.fromJson(queryParams, Course.class);
		}
		int begin=page.getPageSize() * (page.getPageNumber() - 1);
		ArrayList<Course> rows = courseService.querynoexit(course, page, SNO,begin);
		ArrayList<Course> list = courseService.count(course, page, SNO);
		int sum = list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("total", sum);
		map.put("rows", rows);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}
	
	@RequestMapping(value = "/Studenterr.do", method = RequestMethod.POST)
	@ResponseBody
	public String Studenterr(String queryParams,String pageParams,
			HttpSession session, HttpServletResponse response)
	{
		String SNO=(String) session.getAttribute("SNO");	
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String, Object> mapPage = gson.fromJson(pageParams, HashMap.class);
		Page page = new Page();
		page = page.getByHashMap(mapPage); 
		Course course=new Course();
		if(queryParams!=null) {
			course = gson.fromJson(queryParams, Course.class);
		}
		int begin=page.getPageSize() * (page.getPageNumber() - 1);
		ArrayList<Course> rows = courseService.queryexit(course, page, SNO,begin);
		ArrayList<Course> list = courseService.excount(course, page, SNO);
		int sum = list.size();
		HashMap<String, Object> mapreturn = new HashMap<String, Object>();
		mapreturn.put("total", sum);
		mapreturn.put("rows", rows);
		String jsonStr = gson.toJson(mapreturn);
		return jsonStr;		
	}
	
	@RequestMapping(value = "/findall.do", method = RequestMethod.POST)
	@ResponseBody
	public String findall(String queryParams,String pageParams,
			HttpSession session, HttpServletResponse response)
	{	
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String, Object> mapPage = gson.fromJson(pageParams, HashMap.class);
		Page page = new Page();
		page = page.getByHashMap(mapPage); 
		Course course=new Course();
		if(queryParams!=null) {
			course = gson.fromJson(queryParams, Course.class);
		}
		int begin=page.getPageSize() * (page.getPageNumber() - 1);
		ArrayList<Course> rows = courseService.queryAll(course, page,begin);
		ArrayList<Course> list = courseService.classcount(course, page);
		int total =list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}
	
	@RequestMapping(value = "/addclass.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addclass(String CNO,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		//User user=new User();
		//String userName=(String) session.getAttribute("userName");
		//user=userService.get(userName);
		
		String SNO=(String) session.getAttribute("SNO");
		boolean success=courseService.addclass(SNO,CNO);
		if (success) {
			map.put("code", 0);
			map.put("info", "选课成功");
		} else {
			map.put("code", 1);
			map.put("info", "选课失败");
		}
		return map; 				
	}
	
	@RequestMapping(value = "/delclass.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delclass(String CNO,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		String SNO=(String) session.getAttribute("SNO");
		boolean success=courseService.delclass(SNO,CNO);
		if (success) {
			map.put("code", 0);
			map.put("info", "退课成功");
		} else {
			map.put("code", 1);
			map.put("info", "选课失败");
		}
		return map; 				
	}
}
