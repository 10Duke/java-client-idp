package com.tenduke.client.api.idp;

import java.io.Serializable;
import java.util.List;

public class PermissionDefinition implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Permission> permissions;
    private String role;


    /** Returns permissions
     *
     *  @return permissions 
     */

    public List<Permission> getPermissions () {
        return this.permissions;
    }


    /** Sets permissions
     *
     *  @param permissions 
     */

    public void setPermissions (final List<Permission> permissions) {
        this.permissions = permissions;
    }


    /** Returns role
     *
     *  @return role 
     */

    public String getRole () {
        return this.role;
    }


    /** Sets role
     *
     *  @param role 
     */

    public void setRole (final String role) {
        this.role = role;
    }

}
