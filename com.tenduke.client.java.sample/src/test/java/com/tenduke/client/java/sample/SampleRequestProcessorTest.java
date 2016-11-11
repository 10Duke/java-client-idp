package com.tenduke.client.java.sample;

import com.google.gson.Gson;
import com.tenduke.client.ApiConfiguration;
import com.tenduke.client.ApiCredentials;
import com.tenduke.client.ApiProviderRegistry;
import com.tenduke.client.api.idp.IdpApi;
import com.tenduke.client.api.idp.User;
import com.tenduke.client.gson.GsonUtil;
import com.tenduke.client.retrofit.RetrofitUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import retrofit2.converter.gson.GsonConverterFactory;

public class SampleRequestProcessorTest {

    private static final Gson GSON = GsonUtil.createDefaultGson();
    
    private ApiConfiguration _configuration;
    private ApiCredentials _credentials = null; // Credentials are null in this example.
    private ApiProviderRegistry _registry;
    private MockWebServer _server;
    
    private List<User> _users;
    
    @Before
    public void beforeTest () {
        //
        // Setup a mock web-server for the test
        _server = new MockWebServer();

        // Set up some sample arrays
        _users = Arrays.asList (usr(), usr(), usr());
        
        // Configure the API.
        _configuration = new ApiConfiguration (
                _server.url("").toString(),
                GsonConverterFactory.create(GsonUtil.createDefaultGson()),
                RetrofitUtil.buildInitialClient()
        );
        
        // Setup the API-registry ("register API services")
        // API configuration and registry set up should usually be done once
        // in the application.
        //
        // You don't *need* to use the registry, if you don't want to. You can
        // instantiate ApiProviders manually, if necessary, or wrap them inside
        // services etc...
        _registry = new ApiProviderRegistry (_configuration);
        _registry.register (IdpApi.class);
    }
    

    @After
    public void afterTest () throws Exception {
        //
        // The APIs usually shut down automatically, but it may take longish time.
        // You can speed up the shutdown by shutting down the OkHttp-client:
        RetrofitUtil.shutdown(_configuration.getClient());
        
        // 
        _server.shutdown();
    }
    

    @Test
    public void testProcessRequest () throws IOException {
        //
        // Setup the mock web-server responses:
        _server.enqueue(new MockResponse().setBody(GSON.toJson(_users)));
        _server.enqueue(new MockResponse().setBody(GSON.toJson(_users.get (0))));
        _server.enqueue(new MockResponse().setBody(GSON.toJson(_users.get (1))));
        _server.enqueue(new MockResponse().setBody(GSON.toJson(_users.get (2))));
        
        // Create new request processor and process request.
        final SampleRequestProcessor processor = new SampleRequestProcessor(_registry, _credentials);
        processor.processRequest ();

        // Wait for the requests to complete. This is quick-and-dirty solution and
        // just for this particular sample. In real world, you may not even need to do this
        // or should use eg. Semaphores or some other synchronization mechanism.
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch (final InterruptedException e) {
            // Intentionally empty. This is just sample
        }
        
        // Verify the responses:
        final Map<UUID, User> actualUsers = processor.getUsers();

        assertEquals (_users.size(), actualUsers.size ());
        
        for (final User expectedUser : _users) {
            final User actualUser = actualUsers.get (expectedUser.getId ());
            assertNotNull (actualUser);
        }
    }
    

    /** Constructs a user.
     * 
     *  @return 
     */
    private static User usr () {
        //
        final User user = new User ();
        
        user.setId (UUID.randomUUID());
        user.setFirstName ("First name " + user.getId ().toString ());
        user.setLastName ("Last name " + user.getId ().toString ());
        user.setEmail (user.getId () + "@example.net");
        return user;
    }

}
