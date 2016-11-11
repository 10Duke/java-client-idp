package com.tenduke.client.api.idp;

import java.util.List;
import java.util.UUID;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/** Identity Provider API
 */

public interface IdpApi {


    /** Returns a user from the system that the user has access to.
     *
     *  @param query query to filter by
     *  @return user response 
     */

    @GET("api/idp/v1/aggregates/listUsers")
    public Call<User> listUsers (@Query("query") String query);


    /** Creates a new user group. Duplicates are not allowed.
     *
     *  @param item Group object as JSON.
     *  @return group response 
     */

    @POST("api/idp/v1/groups")
    public Call<Group> createGroup (@Body Group item);


    /** Returns all groups from the system that the user has access to.
     *
     *  @param query query to filter by
     *  @param offset offset from where results are read
     *  @param limit maximum number of results to return
     *  @param sortBy field to sort by
     *  @param sortOrder ascending or descending sort
     *  @return groups response 
     */

    @GET("api/idp/v1/groups")
    public Call<List<Group>> findGroups (
            @Query("query") String query,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("sortBy") String sortBy,
            @Query("sortOrder") String sortOrder);


    /** Updates a user group. Duplicates are not allowed.
     *
     *  @param item Group as JSON with fields to update.
     *  @return group response 
     */

    @PUT("api/idp/v1/groups")
    public Call<Group> updateGroup (@Body Group item);


    /** Returns a Group from the system that the user has access to.
     *
     *  @param id id to filter by
     *  @return user group response 
     */

    @GET("api/idp/v1/groups/{id}")
    public Call<Group> findGroup (@Path("id") UUID id);


    /** deletes a single user group based on the ID supplied
     *
     *  @param id id to filter by
     *  @return  
     */

    @DELETE("api/idp/v1/groups/{id}")
    public Call<Void> deleteGroup (@Path("id") UUID id);


    /** Creates a new organization. Duplicates are not allowed.
     *
     *  @param organization Organization object as JSON.
     *  @return organization response 
     */

    @POST("api/idp/v1/organizations")
    public Call<Organization> createOrganization (@Body Organization organization);


    /** Returns all organizations from the system that the user has access to.
     *
     *  @param query query to filter by
     *  @param offset offset from where results are read
     *  @param limit maximum number of results to return
     *  @return organizations response 
     */

    @GET("api/idp/v1/organizations")
    public Call<List<List<Organization>>> findOrganizations (
            @Query("query") String query,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit);


    /** Updates an organization.
     *
     *  @param organization Organization object as JSON with fields to update.
     *  @return organization response 
     */

    @PUT("api/idp/v1/organizations")
    public Call<Organization> updateOrganization (@Body Organization organization);


    /** Finds an organization based on id
     *
     *  @param id id to filter by
     *  @return organization response 
     */

    @GET("api/idp/v1/organizations/{id}")
    public Call<List<Organization>> findOrganization (@Path("id") UUID id);


    /** deletes a single organization based on the ID supplied.
     *
     *  @param id id to filter by
     *  @return  
     */

    @DELETE("api/idp/v1/organizations/{id}")
    public Call<Void> deleteOrganization (@Path("id") UUID id);


    /** Returns a user from the system that the user has access to.
     *
     *  @param category role category to export by
     *  @return exported  roles 
     */

    @GET("api/idp/v1/roleExport/{category}")
    public Call<Role> exportRoles (@Path("category") String category);


    /** Creates a new user role. Duplicates are not allowed.
     *
     *  @param item Role object as JSON.
     *  @return role response 
     */

    @POST("api/idp/v1/roles")
    public Call<Role> createRole (@Body Role item);


    /** Returns all roles from the system that the user has access to.
     *
     *  @param query query to filter by
     *  @param offset offset from where results are read
     *  @param limit maximum number of results to return
     *  @param sortBy field to sort by
     *  @param sortOrder ascending or descending sort
     *  @return groups response 
     */

    @GET("api/idp/v1/roles")
    public Call<List<Role>> findRoles (
            @Query("query") String query,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("sortBy") String sortBy,
            @Query("sortOrder") String sortOrder);


    /** Updates a internal role. Duplicates are not allowed.
     *
     *  @param item Role as JSON with fields to update.
     *  @return role response 
     */

    @PUT("api/idp/v1/roles")
    public Call<Role> updateRole (@Body Role item);


    /** Returns a Role from the system that the user has access to.
     *
     *  @param id id to filter by
     *  @return role response 
     */

    @GET("api/idp/v1/roles/{id}")
    public Call<Role> findRole (@Path("id") UUID id);


    /** deletes a single internal role based on the ID supplied
     *
     *  @param id id to filter by
     *  @return  
     */

    @DELETE("api/idp/v1/roles/{id}")
    public Call<Void> deleteRole (@Path("id") UUID id);


    /** Creates a new user. Duplicates are not allowed.
     *
     *  @param item User object as JSON.
     *  @return user response 
     */

    @POST("api/idp/v1/users")
    public Call<User> createUser (@Body User item);


    /** Returns all users from the system that the user has access to.
     *
     *  @param query query to filter by
     *  @param offset offset from where results are read
     *  @param limit maximum number of results to return
     *  @param sortBy field to sort by
     *  @param sortOrder ascending or descending sort
     *  @return users response 
     */

    @GET("api/idp/v1/users")
    public Call<List<User>> findUsers (
            @Query("query") String query,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("sortBy") String sortBy,
            @Query("sortOrder") String sortOrder);


    /** Updates a user. Duplicates are not allowed.
     *
     *  @param item User as JSON with fields to update.
     *  @return user response 
     */

    @PUT("api/idp/v1/users")
    public Call<User> updateUser (@Body User item);


    /** Returns a user from the system that the user has access to.
     *
     *  @param id id to filter by
     *  @return user response 
     */

    @GET("api/idp/v1/users/{id}")
    public Call<User> findUser (@Path("id") UUID id);


    /** deletes a single user based on the ID supplied
     *
     *  @param id id to filter by
     *  @return  
     */

    @DELETE("api/idp/v1/users/{id}")
    public Call<Void> deleteUser (@Path("id") UUID id);

}
