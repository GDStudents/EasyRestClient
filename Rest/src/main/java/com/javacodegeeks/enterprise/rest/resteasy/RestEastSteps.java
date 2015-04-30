package com.javacodegeeks.enterprise.rest.resteasy;


import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestEastSteps {

    String ROOT_URL = "https://dictionary.yandex.net/api/v1/dicservice";
    String KEY = "dict.1.1.20150426T193111Z.f164df522c929adb.078c0150dc634167bbd61cf61049cd884357d5c2";
    String methodGetLangs = "/getLangs";
    String methodLookup = "/lookup";

    @Test
    public void TestPostRequestGetLang() throws Exception{

        String url = ROOT_URL+methodGetLangs+"?key="+KEY;
        ClientRequest request = new ClientRequest(url);
        ClientResponse<String> response = request.post(String.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String result = response.getEntity();
        System.out.print(result);
    }

    @Test
    public void TestPostRequestLookup() throws Exception{
        ClientRequest request = new ClientRequest(ROOT_URL+methodLookup);
        String data = "key=dict.1.1.20150426T193111Z.f164df522c929adb.078c0150dc634167bbd61cf61049cd884357d5c2&lang=en-ru&text=time";

        request.body("application/x-www-form-urlencoded",data);
        ClientResponse<String> response = request.post(String.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String result = response.getEntity();
        System.out.print(result);
    }




}
