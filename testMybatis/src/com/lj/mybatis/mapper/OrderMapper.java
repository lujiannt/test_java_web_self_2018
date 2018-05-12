package com.lj.mybatis.mapper;

import java.util.List;

import com.lj.mybatis.model.Order;
import com.lj.mybatis.model.User;

/**
 * 如何使用mapper代理
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public interface OrderMapper {
	
	/**
	 * 测试resultMap_复杂使用_one2one
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<Order> getOrdersByResulstMapOne2One() throws Exception;

	/**
	 * 测试resultMap_复杂使用_one2many
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<Order> getOrdersByResulstMapOne2Many() throws Exception;

	/**
	 * 测试resultMap_复杂使用_many2many
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<User> getOrdersByResulstMapMany2Many() throws Exception;
	
	/**
	 * 测试延迟加载_一开始只查询order，在使用到user时再查user
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<Order> getOrdersLazy() throws Exception;
	
	/**
	 * 获取order
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	Order getOrder(int id) throws Exception;
	
	/**
	 * 更新orderNo
	 * @param orderNo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	void updateOrder(Order order) throws Exception;
}
