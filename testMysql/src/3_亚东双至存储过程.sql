--创建语句   注释：DEFINER，INVOKER  https://blog.csdn.net/shiyong1949/article/details/76435499
CREATE DEFINER=`itip_basic_yd`@`%` PROCEDURE `PROCE_ADD`(
IN A varchar(10),IN B varchar(10),OUT C varchar(20))
    SQL SECURITY INVOKER
BEGIN 
	SET C=CONCAT(A,B);
    SELECT C;
END

--调用测试
set @a = 'a';
set @b = 'b';
set @c = 'c';
call PROCE_ADD(@a,@b,@c);
select @a,@b,@c
