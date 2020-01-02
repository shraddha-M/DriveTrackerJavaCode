package com.Drive.utility;

import org.codehaus.jackson.map.ObjectMapper;

public class UtilityJson {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static Object getObjectFromJSON(String jsonString, Class<?> className) {
		Object readValue = null;
		System.out.println(jsonString);

		try {
			readValue = mapper.readValue(jsonString, className);
		} catch (Exception e) {
			System.out.println(e);
		}
		return readValue;

	}

	public static Object getJSONFromObject(Object object) {
		String jsondata = null;

		try {
			jsondata = mapper.writeValueAsString(object);
		} catch (Exception e) {
			System.out.println(e);
		}

		return jsondata;

	}

}
