/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;

/**
 * 角色权限对应关系
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSRolePopedom
        implements Serializable {

    private int roleId;

    private int popedomId;

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

}
