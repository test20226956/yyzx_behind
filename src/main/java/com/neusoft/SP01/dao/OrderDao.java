package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
	
	@Insert("INSERT INTO t_order(customer_id, type, state, date, request) " +
            "VALUES(#{customerId}, #{type}, 1, #{date}, #{request, jdbcType=VARCHAR})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    int insertOrder(Order order);
	
	// 插入订单详情
    @Insert("INSERT INTO t_order_detail(order_id, meal_id, count) " +
            "VALUES(#{orderId}, #{mealId}, #{count})")
    int insertOrderDetail(OrderDetail orderDetail);
    
    // 检查是否已存在当日同类型订单
    @Select("SELECT COUNT(*) FROM t_order " +
            "WHERE customer_id = #{customerId} " +
            "AND type = #{type} " +
            "AND date = #{date} " +
            "AND state = 1")
    int countExistingOrder(@Param("customerId") Integer customerId, 
                          @Param("type") Integer type,
                          @Param("date") String date);
    
    //删除
    @Update("UPDATE t_order SET state = 0 WHERE order_id = #{orderId}")
    int deleteOrder(@Param("orderId") Integer orderId);
    
    //查看点餐情况
    @Select("SELECT " +
            "COALESCE(MAX(CASE WHEN type = 0 THEN 1 ELSE 0 END), 0) as has_breakfast, " +
            "COALESCE(MAX(CASE WHEN type = 1 THEN 1 ELSE 0 END), 0) as has_lunch, " +
            "COALESCE(MAX(CASE WHEN type = 2 THEN 1 ELSE 0 END), 0) as has_dinner " +
            "FROM t_order " +
            "WHERE customer_id = #{customerId} AND date = #{date} AND state = 1")
    DailyMealOrderStatus getDailyMealStatus(@Param("customerId") Integer customerId, 
                                          @Param("date") String date);

    //根据客户id获取订单
    @Select("SELECT * FROM t_order WHERE customer_id = #{customerId} AND state = 1 ORDER BY date DESC")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "mealType", column = "type"),
            @Result(property = "date", column = "date"),
            @Result(property = "request", column = "request"),
            @Result(property = "orderDetails", column = "order_id",
                    many = @Many(select = "com.neusoft.SP01.dao.OrderDao.selectMealDetailsByOrderId"))
    })

    List<CustOrderDTO> getCustomerOrdersWithMeals(@Param("customerId") Integer customerId);

    @Select("SELECT od.meal_id, od.count, " +
            "m.name AS mealName, m.img AS mealImg, m.type AS mealType, m.state AS mealState " +
            "FROM t_order_detail od " +
            "JOIN t_meal m ON od.meal_id = m.meal_id " +
            "WHERE od.order_id = #{orderId}")
    @Results({
            @Result(property = "mealId", column = "meal_id"),
            @Result(property = "count", column = "count"),
            @Result(property = "mealName", column = "mealName"),
            @Result(property = "mealImg", column = "mealImg"),
            @Result(property = "mealType", column = "mealType"),
            @Result(property = "mealState", column = "mealState")
    })
    List<OrderMealDetailDTO> selectMealDetailsByOrderId(@Param("orderId") Integer orderId);

    @Select("""
    <script>
        SELECT * FROM t_order 
        WHERE customer_id = #{customerId}
        AND state = 1
        <if test="date != null and date != ''">
            AND date &gt;= #{date}
        </if>
        ORDER BY date DESC
    </script>
    """)
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "mealType", column = "type"),
            @Result(property = "date", column = "date"),
            @Result(property = "request", column = "request"),
            @Result(property = "orderDetails", column = "order_id",
                    many = @Many(select = "com.neusoft.SP01.dao.OrderDao.selectMealDetailsByOrderId"))
    })
    List<CustOrderDTO> searchOrderByDate(@Param("customerId") Integer customerId,
                                                       @Param("date") String date);




}
