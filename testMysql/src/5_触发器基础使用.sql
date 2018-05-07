--创建触发器   create trigger 触发器名   时间（before after） 对表操作(insert update delete)  on 表名  for each row 
		delimiter $$
		 --订单表插入订单后，商品表自动减少商品数量
		create trigger my_tri1 after insert on lj_order for each row 
		begin                                            --new 代表新插入到订单的一行数据，old则是指修改前的数据
			update lj_product set productNum = productNum - new.productNum where id = new.productId;
		end 
		
		$$
		delimiter;

--查询函数
show triggers 
show create trigger 触发器名
		
--删除函数
drop trigger 触发器名

