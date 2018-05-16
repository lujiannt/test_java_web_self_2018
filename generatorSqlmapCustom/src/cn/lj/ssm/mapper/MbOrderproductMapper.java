package cn.lj.ssm.mapper;

import cn.lj.ssm.po.MbOrderproduct;
import cn.lj.ssm.po.MbOrderproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbOrderproductMapper {
    int countByExample(MbOrderproductExample example);

    int deleteByExample(MbOrderproductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MbOrderproduct record);

    int insertSelective(MbOrderproduct record);

    List<MbOrderproduct> selectByExample(MbOrderproductExample example);

    MbOrderproduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MbOrderproduct record, @Param("example") MbOrderproductExample example);

    int updateByExample(@Param("record") MbOrderproduct record, @Param("example") MbOrderproductExample example);

    int updateByPrimaryKeySelective(MbOrderproduct record);

    int updateByPrimaryKey(MbOrderproduct record);
}