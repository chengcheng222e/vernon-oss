/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;

/**
 * 运营支撑系统角色
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSRole
        implements Serializable {

    private int roleId;

    private String roleName;

    private boolean locked;

    private boolean readOnly;

    private String remark;

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
     * @return the roleId
     */
    public int getRoleId() {
        return this.roleId;
    }

    /**
     * @param roleId
     *            the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the lock
     */
    public boolean isLocked() {
        return this.locked;
    }

    /**
     * @param lock
     *            the lock to set
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
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
