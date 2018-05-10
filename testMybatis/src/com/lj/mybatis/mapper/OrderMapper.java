package com.lj.mybatis.mapper;

import java.util.List;

import com.lj.mybatis.model.Order;

/**
 * 如何使用mapper代理
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public interface OrderMapper {
	
	/**
	 * 测试resultMap (当表列名与model类属性名不一致时使用, 具体可以适用于如本方法中这种情况-order里面有个user)
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<Order> getOrdersByResulstMap(String orderNo) throws Exception;
}
