package com.tenduke.client.api.idp;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private UUID id;
    private UUID ref_Organization_id;
    private String type;
    private List<UUID> userIds;


    /** Returns name
     *
     *  @return name 
     */

    public String getName () {
        return this.name;
    }


    /** Sets name
     *
     *  @param name 
     */

    public void setName (final String name) {
        this.name = name;
    }


    /** Returns id
     *
     *  @return id 
     */

    public UUID getId () {
        return this.id;
    }


    /** Sets id
     *
     *  @param id 
     */

    public void setId (final UUID id) {
        this.id = id;
    }


    /** Returns ref_Organization_id
     *
     *  @return ref_Organization_id 
     */

    public UUID getRef_Organization_id () {
        return this.ref_Organization_id;
    }


    /** Sets ref_Organization_id
     *
     *  @param ref_Organization_id 
     */

    public void setRef_Organization_id (final UUID ref_Organization_id) {
        this.ref_Organization_id = ref_Organization_id;
    }


    /** Returns type
     *
     *  @return type 
     */

    public String getType () {
        return this.type;
    }


    /** Sets type
     *
     *  @param type 
     */

    public void setType (final String type) {
        this.type = type;
    }


    /** Returns userIds
     *
     *  @return userIds 
     */

    public List<UUID> getUserIds () {
        return this.userIds;
    }


    /** Sets userIds
     *
     *  @param userIds 
     */

    public void setUserIds (final List<UUID> userIds) {
        this.userIds = userIds;
    }

}
