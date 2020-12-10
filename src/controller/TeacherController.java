package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ICourseService;
import service.IScoreService;
import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;

@Controller
public class TeacherController {
	
	@Autowired
	private  IScoreService scoreservice;
	@Autowired
	private ICourseService coursedao;
	
	@RequestMapping(value = "/Teacherclass.do", method = RequestMethod.POST)
	@ResponseBody
	public String Teacherclass(String queryParams,String pageParams,
			HttpSession session, HttpServletResponse response)
	{		
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String, Object> mapPage = gson.fromJson(pageParams, HashMap.class);
		Page page = new Page();
		page = page.getByHashMap(mapPage); 
		User user=new User();
		if(queryParams!=null) {
			user = gson.fromJson(queryParams, User.class);
		}
		int begin=page.getPageSize() * (page.getPageNumber() - 1);
		ArrayList<S_C> rows = scoreservice.teacherclass(user, page, begin);
		ArrayList<S_C> list = scoreservice.teachercount(user, page);
		int count=list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", count);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}
	
	
	@RequestMapping(value = "/updatescore.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatescore( String SNO,String CNO,String Score,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		S_C s=new S_C();
		s=coursedao.get(SNO, CNO);
		if(s!=null)
		{
			 boolean success=scoreservice.updateclass(SNO,CNO,Score);
		       
		        if(success)
		        {
		        	map.put("info", "修改成绩成功");
		        	map.put("code", 0);
		        }
		        else
		        {
		        	map.put("info", "修改成绩失败");
		        	map.put("code", 1);
		        }
		}else {
			 boolean success=scoreservice.insertclass(SNO,CNO,Score);
			 if(success)
		        {
		        	map.put("info", "添加成绩成功");
		        	map.put("code", 0);
		        }
		        else
		        {
		        	map.put("info", "添加成绩失败");
		        	map.put("code", 1);
		        }
		}
		
		    return map;
   }

	@RequestMapping(value = "/findclassstudent.do", method = RequestMethod.POST)
	@ResponseBody
	public String findclassstudent(String queryParams,String pageParams,
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
		ArrayList<S_C> rows = coursedao.teacherclassnum(course, page, begin);
		ArrayList<S_C> list = coursedao.teacherclassnumcount(course, page);
		int count=list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", count);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}
	
	
}
