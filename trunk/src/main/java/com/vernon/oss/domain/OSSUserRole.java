/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;

/**
 * 用户角色对应关系
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSUserRole
        implements Serializable {

    private int userId;

    private int roleId;

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
     * @return the userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
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

}
