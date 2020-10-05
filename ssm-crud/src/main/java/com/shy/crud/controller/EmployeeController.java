package com.shy.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shy.crud.bean.Employee;
import com.shy.crud.service.EmployeeService;

/*处理员工crud请求*/
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	//查询员工数据（分页查询）(引入pagehelper插件)
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn, Model model) {
		PageHelper.startPage(pn, 5); //页码变量，每页大小显示条数
		//startpage后跟着的查询即为分页查询
		List<Employee> emps = employeeService.getAll();
		//pageinfo包装查询后的结果，能提供所有分页信息
		PageInfo page = new PageInfo(emps,5);//连续显示5页
		model.addAttribute("pageInfo", page);
		
		return "list";
	}

}
