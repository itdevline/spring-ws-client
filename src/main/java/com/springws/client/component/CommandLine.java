package com.springws.client.component;

import com.genwebservice.Webservicerequest;
import com.genwebservice.Webservicereresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Created by David on 2017.04.25..
 */
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Override
    public void run(String... strings) throws Exception {

        // ***********************************************
        String URI = "http://localhost:8080/ws/mywebservice";
        Webservicerequest webservicerequest = new Webservicerequest();
        webservicerequest.setItemId("2");
        webservicerequest.setItemDesc("desc");
        webservicerequest.setItemName("name");

        // ***********************************************

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

        for(int x=1; x<10;x++) {
            Webservicereresponse webservicereresponse = (Webservicereresponse) webServiceTemplate.marshalSendAndReceive(URI, webservicerequest);

            System.out.println("Response token: " + webservicereresponse.getToken());
        }

    }
}
