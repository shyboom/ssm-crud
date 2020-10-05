package com.shy.crud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.shy.crud.dao.DepartmentMapper;*/
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shy.crud.bean.Department;
import com.shy.crud.dao.DepartmentMapper;


//测试dao层工作
//spring单元测试，可以自动注入组件
// 1、导入springtest模块
// 2、@ContextConfiguration指定spring配置文件的位置
// 3、直接autowired要使用的组件即可
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //scope为test时模块仅test时可用
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper ;
//	测试departmentmapper
	@Test
	public void testCRUD() {
		/*普通测试方法
		 * //创建springIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //从容器中获取mapper
		 * DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(departmentMapper);
		// 插入几个部门
		/* new Department(); */
		departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));
		
   }
}
