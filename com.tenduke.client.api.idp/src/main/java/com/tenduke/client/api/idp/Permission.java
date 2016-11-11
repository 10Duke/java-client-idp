package com.tenduke.client.api.idp;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    private String actions;
    private String permission;


    /** Returns actions
     *
     *  @return actions 
     */

    public String getActions () {
        return this.actions;
    }


    /** Sets actions
     *
     *  @param actions 
     */

    public void setActions (final String actions) {
        this.actions = actions;
    }


    /** Returns permission
     *
     *  @return permission 
     */

    public String getPermission () {
        return this.permission;
    }


    /** Sets permission
     *
     *  @param permission 
     */

    public void setPermission (final String permission) {
        this.permission = permission;
    }

}
