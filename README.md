# Java-client for 10Duke Identity Provider REST API

This project contains Java-client for 10Duke Identity Provider.

This project depends on [10 Duke Java-client core libraries](../java-client-core). Please see that
repository for more details.


## Building

```console
mvn clean install
```


## Sample project

[A sample-project](./com.tenduke.client.java.sample) demonstrates how to declare dependencies and
how to use the Identity Provider API. Start from [SampleRequestProcessorTest](./com.tenduke.client.java.sample/src/test/java/com/tenduke/client/java/sample/SampleRequestProcessorTest.java).


## Dependencies

To use the API declare following dependencies:

This example setup assumes Gson is used for JSON-converter.

```xml
<!-- IdP API: -->
<dependency>
    <groupId>com.tenduke.client.api</groupId>
    <artifactId>idp</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>

<!-- Core library elements -->
<dependency>
    <groupId>com.tenduke.client</groupId>
    <artifactId>core</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>

<!-- Gson-support -->
<dependency>
    <groupId>com.tenduke.client</groupId>
    <artifactId>gson</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>

<!-- Gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.7</version>
    <scope>compile</scope>
</dependency>

<!-- OkHttp -->
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>3.4.1</version>
    <scope>compile</scope>
</dependency>

<!-- Retrofit -->
<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>retrofit</artifactId>
    <version>2.1.0</version>
    <scope>compile</scope>
</dependency>

<!-- Gson Converter.Factory for Retrofit -->
<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>converter-gson</artifactId>
    <version>2.1.0</version>
    <scope>compile</scope>
</dependency>
```

## Using the API

The sample has an example of how to use set up and use IdP API.

Following snippet shows a simple example how to configure and use the API:

```java
// Step 1. Configure the API.
// This typically needs to be done only once
configuration = new ApiConfiguration (
        "https://localhost/api",                                    // Replace with your base URL
        GsonConverterFactory.create(GsonUtil.createDefaultGson()),  // Assumes Gson
        RetrofitUtil.buildInitialClient()                           // Builds OkHttp3-client
);

// Step 2. Setup the API-registry ("register API services")
// This typically needs to be done only once
//
// You don't *need* to use the registry, if you don't want to. You can instantiate ApiProviders
// manually, if necessary, or wrap them inside services etc...
registry = new ApiProviderRegistry (configuration);
registry.register (IdpApi.class);

// Step 3. Create an API instance with given credentials
// A new API instance needed, when credentials or API URL changes.
//
// For example, on an Android app, the credentials are likely to remain the same, so the API
// instance need to be created only once. On java-backend application, each request likely comes
// from different user and may need different credentials.
IdpApi idpApi= apiRegistry.provide(UserApi.class,credentials);

// Step 4. Use the API
// (This example uses synchronous execution)
final Response<List<User>> response = idpApi.findUsers(null, null, null, null, null).execute();

// Success
if (response.isSuccessful()) {
    final List<User> users = response.body();

    // Do something with the data
}
// Call failed
else {
    System.out.printf ("User-listing failed with code %d and message %s%n", response.code(), response.message());
}
```

