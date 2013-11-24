package com.vernon.oss.common.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页提供容器
 * 
 * @author Vernon.Chen
 * @version 1.0 2012-11-21
 */
@SuppressWarnings("serial")
public class PageSplit<T>
	implements Serializable {

	private int totalResult = 0; // 总记录数

	private int totalPage = 1; // 总页数

	private int pageIndex = 1;// 当前页

	private int maxLength = 10; // 每页最多显示多少条记录

	private int fromIndex = 0;// 从第多少条记录开始

	private int toIndex = 0;// 到第多少条记录结束

	private List<T> list = new ArrayList<T>(); // 容器

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}

	public int getToIndex() {
		return toIndex;
	}

	public void setToIndex(int toIndex) {
		this.toIndex = toIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	// ---------------------------- OTHER METHOD --------------------------------

	/**
	 * 是否是第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage() {
		return this.pageIndex <= 1;
	}

	/**
	 * 是否是最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage() {
		return this.pageIndex >= getTotalPage();
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNextPage() {
		if (isLastPage()) {
			return this.pageIndex;
		}
		return this.pageIndex + 1;
	}

	/**
	 * 获取上一页
	 * 
	 * @return
	 */
	public int getPrevPage() {
		if (isFirstPage()) {
			return this.pageIndex;
		}
		return this.pageIndex - 1;
	}

	/**
	 * 分页容器构造方法
	 * 
	 * @param totalResult 总记录数
	 * @param pageIndex 从第几页开始 
	 * @param maxLength 显示记录条数
	 */
	public PageSplit(int totalResult, int pageIndex, int maxLength) {
		// 参数检验
		if (totalResult > 0) {
			this.totalResult = totalResult;
		}
		if (pageIndex > 0) {
			this.pageIndex = pageIndex;
		}
		if (maxLength > 0) {
			this.maxLength = maxLength;
		}
		// 计算总页数
		if (this.totalResult % this.maxLength == 0) {
			this.totalPage = this.totalResult / this.maxLength;
		} else {
			this.totalPage = this.totalResult / this.maxLength + 1;
		}
		if (this.totalPage == 0) {
			this.totalPage = 1;
		}
		if (this.pageIndex <= 0) {
			this.pageIndex = 1;
		}
		if (this.pageIndex > this.totalPage) {
			this.pageIndex = this.totalPage;
		}
		this.fromIndex = (this.pageIndex - 1) * maxLength;
		this.toIndex = this.fromIndex + maxLength;
		if (this.toIndex < 0) {
			this.toIndex = this.fromIndex;
		}
		if (this.toIndex > this.totalResult) {
			this.toIndex = this.totalResult;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pagination:\r\n");
		sb.append("\tpageIndex\t").append(this.pageIndex).append("\r\n");
		sb.append("\ttotalPage\t").append(this.totalPage).append("\r\n");
		sb.append("\tmaxLength\t").append(this.maxLength).append("\r\n");
		sb.append("\ttotalResult\t").append(this.totalResult).append("\r\n");
		for (T t : list) {
			sb.append(t).append("\r\n");
		}
		return sb.toString();
	}
}
