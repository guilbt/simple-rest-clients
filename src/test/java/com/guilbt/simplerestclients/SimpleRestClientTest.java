package com.guilbt.simplerestclients;

import org.springframework.web.client.RestClientException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

public class SimpleRestClientTest {
    private SimpleRestClient fakeClient;
    private final String fakeEndpoint = "/batata";

    @Test
    public void testInstantiation() {
        SimpleRestClient drc = new SimpleRestClient("anyUrl", new HashMap<>());
        Assert.assertNotNull(drc);
    }

    @Test
    public void testInstantiationWithAdditionalHeaders() {
        Map<String, String> addHeaders = new HashMap<String, String>();
        addHeaders.put("testing", "testing");
        SimpleRestClient drc = new SimpleRestClient(addHeaders);
        Assert.assertNotNull(drc);
    }

    @Test
    public void testInstantiationWithAServer() {
        SimpleRestClient drc = new SimpleRestClient("anyUrl");
        Assert.assertNotNull(drc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInstantiationWithNullServer() {
        String nullTestString = null;
        new SimpleRestClient(nullTestString);
    }

    @Test
    public void testInstantiationWithoutParams() {
        new SimpleRestClient();
    }

    @Test(expected = RestClientException.class)
    public void testGetResourceAccessException() {
        fakeClient.get(fakeEndpoint);
    }

    @Test(expected = RestClientException.class)
    public void testPostResourceAccessException() {
        fakeClient.post(fakeEndpoint, "");
    }

    @Test(expected = RestClientException.class)
    public void testPutResourceAccessException() {
        fakeClient.put(fakeEndpoint, "");
    }

    @Test(expected = RestClientException.class)
    public void testDeleteResourceAccessException() {
        fakeClient.delete(fakeEndpoint);
    }

    @Before
    public void setup() {
        fakeClient = new SimpleRestClient("http://fake_url.doesntexist", new HashMap<>());
    }
}
