package com.gbz.myblog.util;

import org.apache.commons.lang.StringUtils;

public class XmlUtil {

	public static String getTagValueFormHtml(String html, String tag) {
		if (StringUtils.isBlank(html) || StringUtils.isBlank(tag)) {
			return null;
		}

		String prefix = "<" + tag + ">";
		String suffix = "</" + tag + ">";
		int startIndex = html.indexOf(prefix);
		int endIndex = html.indexOf(suffix);
		if (startIndex >= endIndex) {
			return null;
		}
		return html.substring(startIndex + prefix.length(), endIndex);
	}
	
}
