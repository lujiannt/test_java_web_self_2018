package cn.lj.ssm.mapper;

import cn.lj.ssm.po.Orderproduct;
import cn.lj.ssm.po.OrderproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderproductMapper {
    int countByExample(OrderproductExample example);

    int deleteByExample(OrderproductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderproduct record);

    int insertSelective(Orderproduct record);

    List<Orderproduct> selectByExample(OrderproductExample example);

    Orderproduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderproduct record, @Param("example") OrderproductExample example);

    int updateByExample(@Param("record") Orderproduct record, @Param("example") OrderproductExample example);

    int updateByPrimaryKeySelective(Orderproduct record);

    int updateByPrimaryKey(Orderproduct record);
}