/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;

/**
 * 运营支撑系统的分组定义
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSGroup
        implements Serializable {

    private int groupId;

    private String groupName;

    private boolean hide;

    private String remark;

    private boolean readOnly;

    /**
     * @return the readOnly
     */
    public boolean isReadOnly() {
        return this.readOnly;
    }

    /**
     * @param readOnly
     *            the readOnly to set
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return the groupId
     */
    public int getGroupId() {
        return this.groupId;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return this.groupName;
    }

    /**
     * @param groupName
     *            the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the hide
     */
    public boolean isHide() {
        return this.hide;
    }

    /**
     * @param hide
     *            the hide to set
     */
    public void setHide(boolean hide) {
        this.hide = hide;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
