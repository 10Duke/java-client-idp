package com.tenduke.client.api.idp;

import java.io.Serializable;
import java.util.UUID;

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private PermissionDefinition definition;
    private UUID id;
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


    /** Returns definition
     *
     *  @return definition 
     */

    public PermissionDefinition getDefinition () {
        return this.definition;
    }


    /** Sets definition
     *
     *  @param definition 
     */

    public void setDefinition (final PermissionDefinition definition) {
        this.definition = definition;
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
