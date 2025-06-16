package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.SP01.dao.EmpDao;
import com.neusoft.SP01.po.Emp;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
@CrossOrigin("*")
@RestController
@RequestMapping("/EmpController")
public class EmpController {
	@Autowired
	private EmpDao ed;
	//条件查询
	@GetMapping("/queryByCon")
	public List<Emp> queryByCon(Emp con){
		QueryWrapper<Emp> qw=new QueryWrapper<>();
		qw.eq("deptno", con.getDeptno()).gt("sal", con.getSal());
		List<Emp> list =ed.selectList(qw);
		return list;
	}
	
	//更新员工信息
	@PostMapping("/updateEmpById")
	public Integer updateEmpById(Emp data) {
		return ed.updateById(data);
	}
	
	@PostMapping("/updateEmpByCon")
	public Integer updateEmpByCon(Emp data) {
		UpdateWrapper<Emp> uw=new UpdateWrapper<>();
		uw.eq("job", data.getJob());
		
		return ed.update(data,uw);
	}
	@PostMapping("/removeEmp")
	public Integer removeEmp(Emp data) {
		QueryWrapper<Emp> qw=new QueryWrapper<>();
		qw.eq("deptno",data.getDeptno()).eq("job", data.getJob());
		return ed.delete(qw);
	}
	@GetMapping("/pageEmp")
	public List<Emp> pageEmp(Long cur,Long num){
		IPage<Emp> page=new Page<>(cur,num);
		IPage<Emp> res=ed.selectPage(page, null);
		List<Emp> list=res.getRecords();
		System.out.println(res.getPages());
		System.out.println(res.getCurrent());
		return list;
	}
	@GetMapping("/pageEmpTwo")
	public PageResponseBean<List<Emp>> pageEmpTwo(Long cur,Long num){
		IPage<Emp> page=new Page<>(cur,num);
		IPage<Emp> res=ed.selectPage(page, null);
		List<Emp> list=res.getRecords();
		long total=res.getTotal();
		PageResponseBean<List<Emp>> rb=null;
		if(total>0) {
			rb=new PageResponseBean<List<Emp>>(list);
			rb.setTotal(total);
		}else {
			rb=new PageResponseBean<List<Emp>>(500,"no data");
		}
		return rb;
	}
}
