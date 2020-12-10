package controller;

import java.util.ArrayList;
import java.util.HashMap;

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
public class ScoreController {
	@Autowired
	private  IScoreService scoreservice;

	
	
	@RequestMapping(value = "/Score.do", method = RequestMethod.POST)
	@ResponseBody
	public String Score(String queryParams,String pageParams,
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
		ArrayList<S_C> rows = scoreservice.Score(user,page,begin);
		ArrayList<S_C> list = scoreservice.scorecount(user, page);
		int count=list.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("total", count);
		String jsonStr = gson.toJson(map);
		return jsonStr;		
	}

}
