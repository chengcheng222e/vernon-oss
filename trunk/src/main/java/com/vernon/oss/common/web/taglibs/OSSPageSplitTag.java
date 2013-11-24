package com.vernon.oss.common.web.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.vernon.oss.common.collection.PageSplit;

/**
 * 后台分页的标签库
 * 
 * @author Vernon.Chen
 */
public class OSSPageSplitTag<T>
		extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String data = "pageSplit";// 数据集合名字

	private String href; // 连接地址

	private StringBuffer output; // 页面输出

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		try {
			output = new StringBuffer();
			hander();
			this.pageContext.getOut().write(output.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@SuppressWarnings({ "unchecked" })
	private void hander() {
		// 如果URL不包含? 则添加?
		if (href.indexOf("?") < 0) {
			href += "?";
		}
		if (href.endsWith("?") || href.endsWith("&amp;")) {
			href += "pageIndex=";
		} else {
			href += "&amp;pageIndex=";
		}
		PageSplit<T> pageSplit = (PageSplit<T>) this.pageContext.getRequest().getAttribute(data);
		if (pageSplit != null) {
			StringBuffer page = new StringBuffer();
			page.append("<div class=\"pagination\">");
			page.append("<a href=\"" + href + 1 + "\" title=\"首页\">&laquo; 首页</a>");
			page.append("<a href=\"" + href + pageSplit.getPrevPage() + "\" title=\"上一页\">&laquo; 上一页</a>");
			if (pageSplit.getTotalPage() <= 4) {// totalPage <=4  的时候
				for (int i = 1; i <= pageSplit.getTotalPage(); i++) {
					page.append("<a href=\"" + href + i + "\"");
					if (pageSplit.getPageIndex() == i) {
						page.append(" class=\"number current\" ");
					} else {
						page.append(" class=\"number\" ");
					}
					page.append(" title=\"" + i + "\" >" + i + "</a>");
				}
			} else if (pageSplit.getTotalPage() > 4 && pageSplit.getTotalPage() <= 9) {// totalPage 在(4,9] 之间的时候
				int endPageIndex = pageSplit.getPageIndex() + 3 > pageSplit.getTotalPage() ? pageSplit.getTotalPage()
						: pageSplit.getPageIndex() + 3;
				for (int i = 1; i <= endPageIndex; i++) {
					page.append("<a href=\"" + href + i + "\"");
					if (pageSplit.getPageIndex() == i) {
						page.append(" class=\"number current\" ");
					} else {
						page.append(" class=\"number\" ");
					}
					page.append(" title=\"" + i + "\" >" + i + "</a>");
				}
				if (pageSplit.getPageIndex() + 3 < pageSplit.getTotalPage()) {
					page.append("...");
				}
			} else {// totalPage 在(9,totalPage] 之间的时候
				if (pageSplit.getPageIndex() + 3 <= 9) {
					for (int i = 1; i <= pageSplit.getPageIndex() + 3; i++) {
						page.append("<a href=\"" + href + i + "\"");
						if (pageSplit.getPageIndex() == i) {
							page.append(" class=\"number current\" ");
						} else {
							page.append(" class=\"number\" ");
						}
						page.append(" title=\"" + i + "\" >" + i + "</a>");
					}
					page.append("...");
				} else {
					int endPageIndex = pageSplit.getPageIndex() + 3 > pageSplit.getTotalPage() ? pageSplit
							.getTotalPage() : pageSplit.getPageIndex() + 3;

					page.append("<a href=\"" + href + 1 + "\" class=\"number\" title=\"1\">1</a>");
					page.append("<a href=\"" + href + 2 + "\" class=\"number\" title=\"2\">2</a>");
					page.append("...");
					for (int i = pageSplit.getPageIndex() - 3; i <= endPageIndex; i++) {
						page.append("<a href=\"" + href + i + "\"");
						if (pageSplit.getPageIndex() == i) {
							page.append(" class=\"number current\" ");
						} else {
							page.append(" class=\"number\" ");
						}
						page.append(" title=\"" + i + "\" >" + i + "</a>");
					}
					if (pageSplit.getPageIndex() + 3 < pageSplit.getTotalPage()) {
						page.append("...");
					}
				}
			}
			page.append("<a href=\"" + href + pageSplit.getNextPage() + "\" title=\"下一页\">&raquo; 下一页</a>");
			page.append("<a href=\"" + href + pageSplit.getTotalPage() + "\" title=\"最后\">&raquo; 最后</a>");
			page.append("</div>");
			output.append(page);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

}
