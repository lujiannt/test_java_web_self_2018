package com.lj.ssm.validate.group;

/**
 * 参数校验分组接口，无需写内容
 * 	使用情景:目前的校验器是写在model里的，所有controller中方法用到它，就会将你在model中定义的所有校验条件都校验。
 * 			如在user中name不能超过5个字，还有个age不能为空就都会校验。但有的方法中我们只需要校验一个name，age为不为null
 * 			无所谓，这时需要用到分组，这个组校验哪几个属性，那个组校验哪几个属性。
 * @author lujian
 * @create 2018年5月28日
 * @version 1.0
 */
public interface ValidateGroup1 {

}
