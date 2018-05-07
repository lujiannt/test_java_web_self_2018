--存储过程：只需编译一次，便可以一直使用，是为了提高效率的完成特定功能sql集

--创建存储过程
1.	
CREATE PROCEDURE my_pro1()  
select * from lj_account;	     --简单的存储过程当只有一个过程体，可以不用begin end

2.	
delimiter $$ --修改语句结束符     注:首尾不加delimiter，在dos窗口中无法使用，在navicat只需要存储过程中即可 

CREATE PROCEDURE my_pro2()
BEGIN                               
	DECLARE i int default 1;      --DECLARE i 局部变量                 
	--DECLARE sum int default 0;
	SET @sum = 0;                 --@sum是会话变量，只对当次会话有用
	
	WHILE i<100 DO                
		SET @sum= @sum+@i;		 --begin end之间叫做过程体
		SET i = i+1;	
	end WHILE;

	SELECT @sum;
END

$$  --语句结束
delimiter;  --修改语句结束符（修改回来）



--查看存储过程
SHOW PROCEDURE STATUS --查看所有存储过程
SHOW CREATE PROCEDURE 过程名  --查看指定的存储过程的创建语句


--调用存储过程
call 存储过程名;

--删除存储过程
drop PROCEDURE 存储过程名;