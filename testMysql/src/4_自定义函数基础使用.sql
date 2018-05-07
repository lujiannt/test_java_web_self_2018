--创建自定义函数  (和存储过程类似，区别于  1.必须要有返回值  2.可以用于select)

	--1.简单函数可以省略begin end
		create function my_fun1() returns int
		return 10;
	
	--2.
		delimiter $$
		
		create function my_fun2(a1 int, a2 int) returns int
		begin
			if a1>a2 then
				return a1;          --过程体中不可以使用select，因为使用就会返回值，和return冲突
			else                    --select..into @a 赋值除外    
				return a2;
			end if;
		end 
		
		$$
		delimiter;

--查询函数
show function status
show create function 函数名
		
--调用函数，可以再select中调用函数
select my_fun1() 
select my_fun2(1,9) 

--删除函数
drop function 函数名

