package com.tenduke.client.api.idp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String temporaryPassword;
    private String displayName;
    private Date validUntil;
    private String description;
    private List<Group> groups;
    private UUID id;
    private Date validFrom;
    private String email;


    /** Returns firstName
     *
     *  @return firstName 
     */

    public String getFirstName () {
        return this.firstName;
    }


    /** Sets firstName
     *
     *  @param firstName 
     */

    public void setFirstName (final String firstName) {
        this.firstName = firstName;
    }


    /** Returns lastName
     *
     *  @return lastName 
     */

    public String getLastName () {
        return this.lastName;
    }


    /** Sets lastName
     *
     *  @param lastName 
     */

    public void setLastName (final String lastName) {
        this.lastName = lastName;
    }


    /** Returns temporaryPassword
     *
     *  @return temporaryPassword 
     */

    public String getTemporaryPassword () {
        return this.temporaryPassword;
    }


    /** Sets temporaryPassword
     *
     *  @param temporaryPassword 
     */

    public void setTemporaryPassword (final String temporaryPassword) {
        this.temporaryPassword = temporaryPassword;
    }


    /** Returns displayName
     *
     *  @return displayName 
     */

    public String getDisplayName () {
        return this.displayName;
    }


    /** Sets displayName
     *
     *  @param displayName 
     */

    public void setDisplayName (final String displayName) {
        this.displayName = displayName;
    }


    /** Returns validUntil
     *
     *  @return validUntil 
     */

    public Date getValidUntil () {
        return this.validUntil;
    }


    /** Sets validUntil
     *
     *  @param validUntil 
     */

    public void setValidUntil (final Date validUntil) {
        this.validUntil = validUntil;
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


    /** Returns validFrom
     *
     *  @return validFrom 
     */

    public Date getValidFrom () {
        return this.validFrom;
    }


    /** Sets validFrom
     *
     *  @param validFrom 
     */

    public void setValidFrom (final Date validFrom) {
        this.validFrom = validFrom;
    }


    /** Returns email
     *
     *  @return email 
     */

    public String getEmail () {
        return this.email;
    }


    /** Sets email
     *
     *  @param email 
     */

    public void setEmail (final String email) {
        this.email = email;
    }

}
