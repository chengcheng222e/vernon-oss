package com.vernon.oss.service;

import java.util.Date;

import com.vernon.oss.common.collection.PageSplit;
import com.vernon.oss.dao.OSSOPDao;
import com.vernon.oss.domain.OSSOP;

/**
 * 后台操作日志
 * 
 * @author Vernon.Chen
 *
 */
public class OSSOPService {

	private static final OSSOPDao ossOPDao = new OSSOPDao();

	/**
	 * 增加操作日志
	 * @param userId		后台用户ID
	 * @param title			操作名
	 * @param content		操作内容
	 * @param IP			操作IP
	 * @param className		操作类名
	 * @param remark		备注
	 * @return				{@link Boolean}
	 */
	public static final boolean addOSSOP(int userId, String title, String content, String IP, String className,
			String remark) {
		return ossOPDao.persist(userId, title, content, IP, className, remark) > 0;
	}

	/**
	 * 查询操作日志列表
	 * @param beginTime		起始时间
	 * @param endTime		结束时间
	 * @param userId		后台用户ID
	 * @param title			操作标题(模糊查询)
	 * @param pageId		页数
	 * @param maxLength		最大记录数
	 * @return				{@link PageSplit<OSSOP>}
	 */
	public static final PageSplit<OSSOP> getOSSOPS(Date beginTime, Date endTime, Integer userId, String title,
			int pageId, int maxLength) {
		int total = ossOPDao.getTotal(beginTime, endTime, userId, title);
		PageSplit<OSSOP> pageSplit = new PageSplit<OSSOP>(total, pageId, maxLength);
		pageSplit.setList(ossOPDao.getOSSOPS(beginTime, endTime, userId, title, pageSplit.getFromIndex(), maxLength));
		return pageSplit;
	}

}
