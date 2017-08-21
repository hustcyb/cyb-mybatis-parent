package com.cyb.spring.boot.mybatis.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Administrator
 *
 */
public final class BeanUtils {

	public static String bean2Json(Object bean) {
		String json;

		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			json = null;
		}

		return json;
	}

	public static <T> T json2Bean(String json, Class<T> beanType) {
		T bean = null;

		ObjectMapper mapper = new ObjectMapper();
		try {
			bean = mapper.readValue(json, beanType);
		} catch (Exception e) {
			bean = null;
		}

		return bean;
	}
}
