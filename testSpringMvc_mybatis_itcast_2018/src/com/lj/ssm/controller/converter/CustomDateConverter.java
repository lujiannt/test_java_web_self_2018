package com.lj.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期参数绑定转换器-将String转换成Date
 * @author lujian
 * @create 2018年5月16日
 * @version 1.0
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String res) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(res);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
