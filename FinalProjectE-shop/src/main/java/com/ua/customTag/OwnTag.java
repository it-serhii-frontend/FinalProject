package com.ua.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Class which performs functionality and content of custom tag
 * 
 * @author Serhii Vyshnevskyi
 */
public class OwnTag extends SimpleTagSupport {

	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public void doTag() throws IOException {
		String bigText = text.toUpperCase();
		JspWriter out = getJspContext().getOut();
		out.println(bigText + " " + "&#9749");
	}

}
