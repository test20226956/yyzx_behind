package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.DietCycle;
import com.neusoft.SP01.po.Meal;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/DeitController")
@RestController
public class DietController {
    //    展示某一天的膳食安排
    @GetMapping("/showDiet")
    public ResponseBean<List<DietCycle>> showDiet(String date){
        return null;
    }

    //    增加一条膳食安排
    @PostMapping("/addDiet")
//    增加后可能还会进行其它操作，所以返回Diet
    public ResponseBean<DietCycle> addDiet(DietCycle data){
        return null;
    }

    //    删除一条膳食安排
    @PostMapping("/deleteDiet")
    public ResponseBean<Integer> deleteDiet(Integer dietId){
        return null;
    }

    //    修改膳食安排配置
    @PostMapping("/editDiet")
    public ResponseBean<Integer> editDiet(DietCycle data){
        return null;
    }

    //    获取全部食物信息
    @GetMapping("/showFood")
    public ResponseBean<List<Meal>> showFood(Integer type){
        return null;
    }

    //    添加食物
    @PostMapping("/addFood")
    public ResponseBean<Integer> addFood(){
        return null;
    }
    //    根据食物名称查找食物
    @GetMapping("/searchFood")
    public ResponseBean<List<Meal>> searchFood(){
        return null;
    }
    //    修改食物信息
    @PostMapping("/editFood")
    public ResponseBean<Integer> editFood(Meal data){
        return null;
    }

    //    删除存在的食物
    @PostMapping("/deleteFood")
    public ResponseBean<Integer> deleteFood(Integer foodId){
        return null;
    }
}
