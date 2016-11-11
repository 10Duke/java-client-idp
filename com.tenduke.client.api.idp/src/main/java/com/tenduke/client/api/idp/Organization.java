package com.tenduke.client.api.idp;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String founded;
    private String description;
    private List<Group> groups;
    private String id;
    private String type;


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


    /** Returns founded
     *
     *  @return founded 
     */

    public String getFounded () {
        return this.founded;
    }


    /** Sets founded
     *
     *  @param founded 
     */

    public void setFounded (final String founded) {
        this.founded = founded;
    }


    /** Returns description
     *
     *  @return description 
     */

    public String getDescription () {
        return this.description;
    }


    /** Sets description
     *
     *  @param description 
     */

    public void setDescription (final String description) {
        this.description = description;
    }


    /** Returns groups
     *
     *  @return groups 
     */

    public List<Group> getGroups () {
        return this.groups;
    }


    /** Sets groups
     *
     *  @param groups 
     */

    public void setGroups (final List<Group> groups) {
        this.groups = groups;
    }


    /** Returns id
     *
     *  @return id 
     */

    public String getId () {
        return this.id;
    }


    /** Sets id
     *
     *  @param id 
     */

    public void setId (final String id) {
        this.id = id;
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

}
