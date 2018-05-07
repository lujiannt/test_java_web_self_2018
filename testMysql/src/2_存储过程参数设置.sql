--步骤1:设置三个会话变量;
set @n1=1;
set @n2=1;
set @n3=1;

--步骤2:创建存储过程
	--in:只是从外面读取到过程体；
	--out：不读取，但是写出到外面；
	--inout:既读取，也写出到外面
CREATE PROCEDURE my_pro3(in int_1 int,out int_2 int,inout int_3 int)
begin
	SELECT int_1,int_2,int_3;
	set int_1 = 10;
  	set int_2 = 100;
  	set int_3 = 1000;

  	set @n1='a';
	set @n2='b';
	set @n3='c';

 	SELECT int_1,int_2,int_3;
end;

--步骤3:调用存储过程,检查实验结果
CALL my_pro3(@n1,@n2,@n3);  --调用后，@n1='a',@n1=100,@n1=1000
