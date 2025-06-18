package com.neusoft.SP01.po;

// 这个类是为了显示客户护理设置表中的数据
public class CustomerNursingDTO {
    //客户类部分的信息
    private Integer customerId;
    private Integer age;
    private Integer gender;
    private String tel;

    // 入住部分信息 - 需要根据客户id来找到对应入住记录
    private Integer nursingLevel;

    // 床位信息 - 需要根据入住记录id找到床位使用记录，根据记录中的房间和床位id来取得
    private String roomNumber;
    private String bedNumber;
    private String building;

}
