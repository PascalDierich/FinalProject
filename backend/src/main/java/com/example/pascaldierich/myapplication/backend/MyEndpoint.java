/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.pascaldierich.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.pascaldierich.example.com",
                ownerName = "backend.myapplication.pascaldierich.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    com.example.MyClass comedian = new com.example.MyClass();

    /**
     * A simple endpoint method that takes returns a Joke :D
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        response.setData(comedian.getJoke());

        return response;
    }

}
