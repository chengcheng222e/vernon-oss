/**
 * 
 */
package com.vernon.oss.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 运营支撑系统用户环境数据
 * 
 * @author Vernon.Chen
 *
 */
@SuppressWarnings("serial")
public class OSSContext
        implements Serializable {

    private OSSUser user;

    private Set<OSSPopedom> popedoms;

    private Set<OSSRole> roles;

    private String URI;

    /**
     * @return the user
     */
    public OSSUser getUser() {
        return this.user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(OSSUser user) {
        this.user = user;
    }

    /**
     * @return the popedoms
     */
    public Set<OSSPopedom> getPopedoms() {
        return this.popedoms;
    }

    /**
     * @param popedoms
     *            the popedoms to set
     */
    public void setPopedoms(Set<OSSPopedom> popedoms) {
        this.popedoms = popedoms;
    }

    /**
     * @return the roles
     */
    public Set<OSSRole> getRoles() {
        return this.roles;
    }

    /**
     * @param roles
     *            the roles to set
     */
    public void setRoles(Set<OSSRole> roles) {
        this.roles = roles;
    }

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

}
