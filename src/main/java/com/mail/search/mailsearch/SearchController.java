package com.mail.search.mailsearch;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/")
    public String getAll(String TrackingId) throws  Exception{
        String temp = "API=TrackV2&XML=<TrackRequest USERID='737TEMP03637'><TrackID ID='9374889670090489947667'></TrackID></TrackRequest>";
        CloseableHttpClient httpClient = HttpClients.createDefault();



        URIBuilder builder = new URIBuilder("http://production.shippingapis.com/ShippingAPI.dll");
        builder.setParameter("API", "TrackV2");
        builder.setParameter("XML", "<TrackRequest USERID='737TEMP03637'><TrackID ID='9374889670090489947667'></TrackID></TrackRequest>");
        System.out.println(builder.build());

        HttpGet request = new HttpGet(builder.build());
        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String staus = EntityUtils.toString(entity);
//        System.out.println(EntityUtils.toString(entity));



        return staus;
    }

}
