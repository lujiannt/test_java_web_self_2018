package cn.lj.ssm.mapper;

import cn.lj.ssm.po.MbUser;
import cn.lj.ssm.po.MbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MbUserMapper {
    int countByExample(MbUserExample example);

    int deleteByExample(MbUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MbUser record);

    int insertSelective(MbUser record);

    List<MbUser> selectByExample(MbUserExample example);

    MbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MbUser record, @Param("example") MbUserExample example);

    int updateByExample(@Param("record") MbUser record, @Param("example") MbUserExample example);

    int updateByPrimaryKeySelective(MbUser record);

    int updateByPrimaryKey(MbUser record);
}