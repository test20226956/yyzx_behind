package com.neusoft.SP01;

import com.neusoft.SP01.dao.*;
import com.neusoft.SP01.po.*;
import com.neusoft.SP01.service.OutRecordService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class Sp01ApplicationTests {
	
	
	@Test
	void contextLoads() {
		
	}
	@Autowired
	private CustomerDao c;
	@Autowired
	private NursingRecordDao n;
	@Autowired
	private NursingServiceDao nsd;
	@Autowired
	private CheckOutRecordDao cord;
	@Autowired
	private OutRecordDao ord;
	@Test
	void showuserCust(){
		List<CustDailyNursingDTO> userCust = c.findUserCust(101);
		System.out.println(userCust);
	}
	@Test
	void findUserCustManage(){
		List<CustNursingManageDTO> userCustManage = c.findUserCustManage(101);
		System.out.println(userCustManage);
	}
	@Test
	void showuserCustByName(){
		List<CustDailyNursingDTO> userCust = c.findUserCustByName(101,"三");
		System.out.println(userCust);
	}
	@Test
	void findByCustomerId(){
		List<CustNursingRecordDTO> cnd = n.findByCustomerId(1);
		System.out.println(cnd);
	}
	@Test
	void findByNameAndTime(){
		List<CustDailyNursingDTO> l = n.findByNameAndTime(1, "李", null);
		System.out.println(l);
	}
	@Test
	void findNursingServiceByCustomerId(){
		List<NursingServiceDailyDTO> n = nsd.findNursingServiceByCustomerId(1);
		System.out.println(n);
	}
	@Test
	void findNursingServiceByName(){
		List<NursingServiceDailyDTO> y = nsd.findNursingServiceByName(1, "药");
		System.out.println(y);
	}
	@Test
	void findUserCustManageByName(){
		List<CustNursingManageDTO> l = c.findUserCustManageByName(1, "李");
		System.out.println(l);
	}
	@Test
	void findCheckOutRecordByCustomerId(){
		List<CustCheckOutDTO> c = cord.findCheckOutRecordByCustomerId(1);
		System.out.println(c);
	}
	@Test
	void findOutRecordByCustomerId(){
		List<CustOutRecordDTO> o = ord.findOutRecordByCustomerId(1);
		System.out.println(o);
	}

	/*===service====*/
	@Autowired
	private OutRecordService ors;
	@Test
	void ors1(){
		PageResponseBean<List<CustOutRecordDTO>> o = ors.findOutRecordByCustomerId(1,2,1);
		System.out.println(o);
	}
}
