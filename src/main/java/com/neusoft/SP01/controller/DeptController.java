package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.neusoft.SP01.dao.DeptDao;
import com.neusoft.SP01.po.Dept;
import com.neusoft.SP01.po.ResponseBean;
@CrossOrigin("*")
@RequestMapping("/DeptController")
@RestController
/**
 * ~~~
 * ~~
 * ！
 */
public class DeptController {
	
	@Autowired
	private DeptDao dd;
	
	@PostMapping("/ad")
	public Integer test(){
		return null;
	}
	//实体类对象
	@PostMapping("/addDept")//只能用在方法上不能写在类上
	public Integer addDept(Dept data) {
		System.out.println(data.getDname()+","+data.getLoc()+","+data.getDeptno()+",");
		Integer res=dd.insert(data);
		return res;
	}
	//数组
	@GetMapping("/queryByDeptno")
	public List<Dept> queryByDeptno(Integer [] deptno){
		for(Integer x:deptno) {
			System.out.println(x);
		}
		return null;
	}
	
	//参数名不一致的传输
	@PostMapping("/addDeptTwo")
	public Integer addDeptTwo(@RequestParam("bh") Integer deptno,@RequestParam("mz")
			String dname,@RequestParam("dd") String loc) {
		System.out.println(deptno+","+dname+","+loc);
		return 1;
		
	}
	
	//复杂数据 必须post 必须@RequestBody
	@PostMapping("/addDeptList")
	public Integer addDeptList(@RequestBody List<Dept> list) {
		for(Dept d:list) {
			System.out.println(d.getDeptno()+","+d.getDname()+","+d.getLoc());
		}
		return list.size();
	}
	@GetMapping("/queryDeptById")
	public Dept queryDeptById(Integer deptno) {
		return dd.selectById(deptno);
	}
	
	@GetMapping("/queryAll")
	public ResponseBean<List<Dept>> queryAll(){
		List<Dept> list=dd.selectList(null);
		ResponseBean<List<Dept>> rb=null;
		if(list.size()>0) {
			rb=new ResponseBean<>(list);
		}else {
			rb=new ResponseBean<>(500,"no data");
		}
		return rb;
	}
	@PostMapping("/updateDept")
	public ResponseBean<Integer> updateDept(Dept data){
		Integer result;
		ResponseBean<Integer> rb=null;
		try {
			result = dd.updateById(data);
			rb=new ResponseBean<>(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rb=new ResponseBean<>(500,"更新失败");
		}
		
		return rb;
		
	}
	
}
