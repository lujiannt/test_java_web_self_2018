package com.lj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * struts类型转换器
 * @author lujian
 * @create 2017年3月27日
 * @version 1.0
 */
public class MyTypeConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		String value = values[0];
		System.out.println(value);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM/dd");
		Date da = null;
		try {
			da = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return da;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
