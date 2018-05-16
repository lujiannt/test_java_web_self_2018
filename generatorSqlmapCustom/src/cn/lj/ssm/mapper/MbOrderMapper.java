package cn.lj.ssm.mapper;

import cn.lj.ssm.po.MbOrder;
import cn.lj.ssm.po.MbOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbOrderMapper {
    int countByExample(MbOrderExample example);

    int deleteByExample(MbOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MbOrder record);

    int insertSelective(MbOrder record);

    List<MbOrder> selectByExample(MbOrderExample example);

    MbOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MbOrder record, @Param("example") MbOrderExample example);

    int updateByExample(@Param("record") MbOrder record, @Param("example") MbOrderExample example);

    int updateByPrimaryKeySelective(MbOrder record);

    int updateByPrimaryKey(MbOrder record);
}