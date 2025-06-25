package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.SP01.dao.CheckInRecordDao;
import com.neusoft.SP01.dao.NursingServiceDao;
import com.neusoft.SP01.po.NursingService;
import com.neusoft.SP01.po.NursingServiceDailyDTO;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;

@Service
@Transactional(rollbackFor = Exception.class) // 所有异常都触发回滚
public class NursingServiceService {
    @Autowired
    private NursingServiceDao nsd;
    @Autowired
    private CheckInRecordDao cird;
    
    /*======对应原型护工 日常护理 显示用户的护理服务=====*/
    public PageResponseBean<List<NursingServiceDailyDTO>> findNursingServiceByCustomerId(Integer pageNum, Integer pageSize, Integer customerId){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<NursingServiceDailyDTO> cords = nsd.findNursingServiceByCustomerId(customerId);
        // 3. 获取分页信息
        Page<NursingServiceDailyDTO> p =(Page<NursingServiceDailyDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<NursingServiceDailyDTO>> response = new PageResponseBean<>();
        if(p.getTotal()!=0){
            response.setStatus(200); // 成功状态码
            response.setMsg("查询成功"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }else{
            response.setStatus(500); // 成功状态码
            response.setMsg("无数据"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }
        return response;
    }
    //对应原型护工 日常护理  按项目名字搜索用户的持有的护理服务
    public PageResponseBean<List<NursingServiceDailyDTO>> findNursingServiceByName(Integer pageNum, Integer pageSize, Integer customerId,String name){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<NursingServiceDailyDTO> cords = nsd.findNursingServiceByName(customerId,name);
        // 3. 获取分页信息
        Page<NursingServiceDailyDTO> p =(Page<NursingServiceDailyDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<NursingServiceDailyDTO>> response = new PageResponseBean<>();
        if(p.getTotal()!=0){
            response.setStatus(200); // 成功状态码
            response.setMsg("查询成功"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }else{
            response.setStatus(500); // 成功状态码
            response.setMsg("无数据"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }
        return response;
    }
    
    //移除护理级别及服务
    public ResponseBean<Integer> deleteNursingLevel(Integer customerId) {
        try {
            // 1. 参数校验
            if (customerId == null) {
                return new ResponseBean<>(500, "客户ID不能为空");
            }

            // 2. 级联操作1：移除客户护理级别（设为NULL）
            int updatedRecords = cird.clearNursingLevelByCustomerId(customerId);

            // 3. 级联操作2：禁用该客户在当前级别的所有护理服务
            int disabledServices = nsd.deleteNursingService(customerId);


            return new ResponseBean<>(200, "移除成功", updatedRecords + disabledServices);

        } catch (Exception e) {
            return new ResponseBean<>(500, "移除失败: " + e.getMessage());
        }
    }
    
    @Transactional
    public ResponseBean<Integer> batchAddNursingServices(List<NursingService> nursingServices) {
        try {
            if (nursingServices == null || nursingServices.isEmpty()) {
                return new ResponseBean<>(500, "护理服务列表不能为空");
            }

            int affectedRows = nsd.batchInsertNursingServices(nursingServices);
            
            if (affectedRows > 0) {
                return new ResponseBean<>(200,"添加成功",affectedRows);
            } else {
                return new ResponseBean<>(500, "添加失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("系统错误: " + e.getMessage(), e);
        }
    }
    
    
    
}