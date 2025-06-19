package com.neusoft.SP01;

import com.neusoft.SP01.dao.CustomerDao;
import com.neusoft.SP01.dao.NursingRecordDao;
import com.neusoft.SP01.dao.NursingServiceDao;
import com.neusoft.SP01.po.CustDailyNursingDTO;
import com.neusoft.SP01.po.NursingServiceDailyDTO;
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
	@Test
	void showuserCust(){
		List<CustDailyNursingDTO> userCust = c.findUserCust(101);
		System.out.println(userCust);
	}
	@Test
	void showuserCustByName(){
		List<CustDailyNursingDTO> userCust = c.findUserCustByName(101,"三");
		System.out.println(userCust);
	}
	@Test
	void findByCustomerId(){
		List<CustDailyNursingDTO> cnd = n.findByCustomerId(1);
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
}
