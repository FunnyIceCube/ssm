package org.lzh.demo.ssm;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lzh.demo.ssm.domain.User;
import org.lzh.demo.ssm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class HelloController {

	@Resource  
    private IUserService userService;  
	
	@RequestMapping("/hello")
	public String hello(){
		return "mvc";
	}
	
	@RequestMapping(value="/hello", params="method=1")
	public String hello1(String name, int age){
		System.out.println("name:"+name+", age:"+age);
		return "mvc";
	}
	
	@RequestMapping(value="/hello/{name}", params="method=2")
	public String hello1(@PathVariable("name") Integer name){
		System.out.println("name:"+name);
		return "mvc";
	}
	
	@RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
	}
}
