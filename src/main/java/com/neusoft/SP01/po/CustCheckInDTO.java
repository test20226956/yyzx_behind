package com.neusoft.SP01.po;

//这是入住登记页面的表格字段视图类
//不与数据库进行交互

public class CustCheckInDTO {
    private CheckInRecord checkInRecord;
    private Customer customer;
    private Family family;
    private BedRecord bedRecord;

//  年龄
    private Integer age;

////  入住登记id
//    private Integer checkInRecordId;
////  老人姓名
//    private String customerName;
////  客户年龄（讨论在前端还是后端计算）
//    private Integer age;
////  性别
//    private Integer gender;
////  身份证号
//    private String identity;
////  血型
//    private String bloodType;
////  客户本人的联系电话
//    private String tel;
////  联系人
//    private String familyName;
////  联系人电话
//    private String familyTel;
////  楼层
//    private String floor;
////  房间号
//    private String room;
////  床位号
//    private String bed;
////  入住时间
//    private String checkInTime;
////  合约到期时间
//    private String endTime;
}
