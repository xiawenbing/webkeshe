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

import service.IClassMangerService;
import service.IUserMangerService;
import service.IUserService;
import vo.Course;
import vo.Page;
import vo.User;

@Controller
public class MangerController {
	@Autowired
	private IUserMangerService mangerdao;
	@Autowired 
	private IClassMangerService classdao;
	
	@RequestMapping(value = "/userManger.do", method = RequestMethod.POST)
	@ResponseBody
	public String userManger(String queryParams,String pageParams,
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
		ArrayList<User> rows = mangerdao.query(user, page, begin);
		ArrayList<User> list = mangerdao.usercount(user);
		int total =list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}
	
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteUser( String SNO,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
        boolean success=mangerdao.deleteuser(SNO);
        if(success)
        {
        	map.put("info", "删除用户成功");
        	map.put("code", 0);
        }
        else
        {
        	map.put("info", "删除用户失败");
        	map.put("code", 1);
        }
		    return map;
   }
	
	@RequestMapping(value = "/Insertclass.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Insertclass( String CNO,String CName,String Point,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		Course course =new Course();
		course=classdao.get(CNO);
		if(course==null)
		{
		 boolean success=classdao.insertclass(CNO, CName, Point);
		 if(success)
	        {
	        	map.put("info", "新增课程成功");
	        	map.put("code", 0);
	        }
	        else
	        {
	        	map.put("info", "新增课程失败");
	        	map.put("code", 1);
	        }
		    
		}
		else
		{
			 boolean success=classdao.updatecalss(Point, CNO);
			 if(success)
		        {
		        	map.put("info", "修改课程信息成功");
		        	map.put("code", 0);
		        }
		        else
		        {
		        	map.put("info", "修改课程信息失败");
		        	map.put("code", 1);
		        }
		}
		return map;
   }
	
	@RequestMapping(value = "/delcalss.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delcalss( String CNO,
			HttpSession session, HttpServletResponse response) {
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
        boolean success=classdao.deletclass(CNO);
        if(success)
        {
        	map.put("info", "删除课程成功");
        	map.put("code", 0);
        }
        else
        {
        	map.put("info", "删除课程失败");
        	map.put("code", 1);
        }
		    return map;
   }
}
