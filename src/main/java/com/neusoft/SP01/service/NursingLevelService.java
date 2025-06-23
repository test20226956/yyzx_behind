package com.neusoft.SP01.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.SP01.dao.NursingLevelDao;
import com.neusoft.SP01.dao.NursingLevelProjectDao;
import com.neusoft.SP01.po.NursingLevel;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;

@Service
@Transactional
public class NursingLevelService {
	@Autowired
    private NursingLevelDao nld;
	@Autowired
    private NursingLevelProjectDao nlpd;
	
	public PageResponseBean<List<NursingLevel>> searchLevels(
            String name, 
            Integer state, 
            Long pageNum, 
            Long pageSize) {
        
        try {
            // 1. 参数处理
            pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;
            pageSize = (pageSize == null || pageSize < 1 || pageSize > 100) ? 10 : pageSize;
            state = (state == null) ? 1 : state; // 默认状态为1
            
            // 2. 计算偏移量
            Long offset = (pageNum - 1) * pageSize;
            
            // 3. 执行查询
            List<NursingLevel> levels = nld.searchLevels(
                name, state, offset, pageSize);
            
            // 4. 处理空结果
            if (levels.isEmpty()) {
                return new PageResponseBean<>(500, "无数据", null);
            }
            
            // 5. 获取总数
            Long total = nld.countSearchLevels(name, state);
            
            // 6. 构建响应
            PageResponseBean<List<NursingLevel>> response = 
                new PageResponseBean<>(200, "查询成功", levels);
            response.setTotal(total);
            return response;
            
        } catch (Exception e) {
            return new PageResponseBean<>(500, "系统错误：" + e.getMessage(), null);
        }
    }
	//添加护理级别
	public ResponseBean<Integer> addNursingLevel(NursingLevel nursingLevel) {
        try {
            // 设置默认状态为1（启用），如果未设置
            if (nursingLevel.getState() == null) {
                nursingLevel.setState(1);
            }
            
            int result = nld.insert(nursingLevel);
            if (result > 0) {
                return new ResponseBean<>(200, "添加成功", nursingLevel.getNursingLevelId());
            } else {
                return new ResponseBean<>(500, "添加失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean<>(500, "系统错误：" + e.getMessage(), null);
        }
    }
	
	//删除护理级别
	public ResponseBean<Integer> deleteNursingLevel(Integer nursingLevelId) {
        try {
            // 1. 检查护理级别是否存在
            NursingLevel level = nld.selectById(nursingLevelId);
            if (level == null) {
                return new ResponseBean<>(500, "未找到指定的护理级别", null);
            }
            
            // 2. 先删除关联的护理项目（设置state=0）
            int affectedProjects = nlpd.updateStateByLevelId(nursingLevelId);
            
            // 3. 再删除护理级别本身（设置state=0）
            int affectedLevel = nld.deleteNursingLevel(nursingLevelId);
            
            // 4. 返回受影响的总记录数
            int totalAffected = affectedLevel + affectedProjects;
            
            if (totalAffected > 0) {
                return new ResponseBean<>(200, "删除成功", totalAffected);
            } else {
                return new ResponseBean<>(500, "删除操作未影响任何记录", 0);
            }
        } catch (Exception e) {
            // 事务会自动回滚
            e.printStackTrace();
            return new ResponseBean<>(500, "系统错误：" + e.getMessage(), null);
        }
    }
}