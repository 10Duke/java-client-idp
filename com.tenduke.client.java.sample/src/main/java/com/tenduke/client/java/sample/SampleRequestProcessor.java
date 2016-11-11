package com.tenduke.client.java.sample;

import com.tenduke.client.ApiCredentials;
import com.tenduke.client.ApiProviderRegistry;
import com.tenduke.client.api.idp.IdpApi;
import com.tenduke.client.api.idp.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/** A simple, minimal sample request processor.
 * 
 *  <p>
 *  This simulates a simple backend-application, which uses the UserApi.
 *  Each request is likely done by different user with different credentials.
 *  For each request, a new SampleRequestProcessor instance is constructed, then
 *  processRequest is called.
 * 
 *  <p>
 *  Since each request likely uses different credentials, a new UserApi instance
 *  is constructed, with the given credentials. However, during the request, the
 *  same UserApi instance can be re-used, as the credentials stay the same.
 */
public class SampleRequestProcessor {
    
    private final IdpApi _idpApi;
    
    // Fetched users. This is for the unit test to verify that all users have been fetched.
    private final Map<UUID, User> _users = new HashMap<> ();


    /** Constructs new instance.
     * 
     * @param apiRegistry Registry of APIs
     * @param credentials Credentials to use.
     */
    public SampleRequestProcessor(
            final ApiProviderRegistry apiRegistry,
            final ApiCredentials credentials) {
        //
        _idpApi = apiRegistry.provide(IdpApi.class, credentials);
    }


    /** This method simulates a processing of a single request.
     * 
     *  @throws IOException -
     */
    public void processRequest () throws IOException {
        //
        // Synchronously list all users
        final Response<List<User>> response = _idpApi.findUsers(null, null, null, null, null).execute();
        
        // Call succeeded
        if (response.isSuccessful()) {
            //
            final List<User> users = response.body();
            
            if (users != null) {
                
                for (final User user : users) {
                    
                    // Asynchronously process each user... lets see what kind of mess that creates :)
                    // Note how the same UserApi instance is used here, this is ok as the credentials
                    // have not changed
                    if (user.getId() != null) {
                        
                        _idpApi.findUser(user.getId ()).enqueue(new ProcessUserCallback (user.getId()));
                        
                    }
                    
                }
            }
        }
        // Call failed
        else {
            System.out.printf ("User-listing failed with code %d and message %s%n", response.code(), response.message());
        }
    }
    

    /** Get the resulting users (for our test only).
     * 
     * @return the users read.
     */
    public Map<UUID, User> getUsers () {
        //
        return _users;
    }


    /** Simple example, how the callback can be implemented as nested-class.
     *  
     *  This can keep the main code more readable, depending on your preferences.
     * 
     *  Note this is intentionally an inner class, so that it can access, if necessary, the enclosing class
     *  instance.
     * 
     */
    private class ProcessUserCallback implements Callback<User> {
        
        private final UUID _id;


        /** Constructs new callback. Captures the user id.
         * 
         * @param id userId
         */
        public ProcessUserCallback(final UUID id) {
            _id = id;
        }


        /** Handles response.
         * 
         * @param call -
         * @param response -
         */
        @Override
        public void onResponse(final Call<User> call, final Response<User> response) {
            //
            System.out.printf ("GET response for user id %s...%n", _id.toString());
            //
            if (response.isSuccessful()) {
                //
                final User user = response.body();
                if (user == null) {
                    System.out.println ("  Response was null!");
                }
                else {
                    // Add the user received into the user-map of the
                    // enclosing class. This is just for verifying results in
                    // the unit test.
                    synchronized (_users) {
                        _users.put (user.getId(), user);
                    }
                    System.out.printf ("  Firstname %s%n", user.getFirstName());
                    System.out.printf ("  Lastname  %s%n", user.getLastName());
                    System.out.printf ("  Email     %s%n", user.getEmail());
                }
            }
            // If HTTP-error:
            else {
                System.out.printf ("HTTP-error: %d \"%s\"%n", response.code(), response.message());
            }
        }


        /** Handles network failure.
         * 
         *  On failures (e.g. network failure, DNS not found etc), the synchronous calls throw an exception.
         *  Async calls call the onFailure-callback.
         * 
         * @param call -
         * @param thrwbl - 
         */
        @Override
        public void onFailure(Call<User> call, Throwable thrwbl) {
            //
            System.out.printf ("Fatal error while trying to GET user id %s...%n", _id.toString());
        }

    }

}
