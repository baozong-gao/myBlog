package com.gbz.myblog.util;

public final class BFConstants extends ConfigurableContants {

	static {
		init("/bfconfig.properties"); // classpath下
	}

	public static final String KEYSTORE_PATH = getProperty("keyStore.Path",
			null);
	public static final String KEYSTORE_PASSWORD = getProperty(
			"keyStore.Password", null);
	public static final String PUB_KEY = getProperty("pub.key", null);
	public static final String PAY_URL = getProperty("pay.url", null);
	public static final String QUERY_URL = getProperty("query.url", null);
	public static final String MEMBER_ID = getProperty("member.Id", null);
	public static final String TERMINAL_ID = getProperty("terminal.Id", null);

	public static String getStringByKey(String key) {
		return getProperty(key);
	}
}
