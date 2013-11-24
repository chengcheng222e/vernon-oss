/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;

/**
 * 运营支撑系统权限设定
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSPopedom
        implements Serializable {

    private int popedomId;

    private int groupId;

    private String popedomName;

    private boolean locked;

    private boolean hide;

    private boolean readOnly;

    private String URI;

    private String remark;

    /**
     * @return the uRI
     */
    public String getURI() {
        return this.URI;
    }

    /**
     * @param uRI
     *            the uRI to set
     */
    public void setURI(String uRI) {
        this.URI = uRI;
    }

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
     * @return the popedomId
     */
    public int getPopedomId() {
        return this.popedomId;
    }

    /**
     * @param popedomId
     *            the popedomId to set
     */
    public void setPopedomId(int popedomId) {
        this.popedomId = popedomId;
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
     * @return the popedomName
     */
    public String getPopedomName() {
        return this.popedomName;
    }

    /**
     * @param popedomName
     *            the popedomName to set
     */
    public void setPopedomName(String popedomName) {
        this.popedomName = popedomName;
    }

    /**
     * @return the locked
     */
    public boolean isLocked() {
        return this.locked;
    }

    /**
     * @param locked
     *            the locked to set
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
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
