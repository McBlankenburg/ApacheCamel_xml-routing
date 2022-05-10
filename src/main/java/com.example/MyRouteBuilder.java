package com.example;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    /**
     * @author Maciej Blankenburg
     *
     * changing noop to false on messages from /data will be moved to the /data/.camel folder
     */
    public void configure() {
        from("file:src/data?noop=true")
            .choice()
                .when(xpath("/Order/CustomerID = 'GREAL'"))
                    .log("GREAL message")
                    .to("file:target/messages/GREAL")
                .when(xpath("/Order/CustomerID = 'HUNGC'"))
                    .log("HUNGC message")
                    .to("file:target/messages/HUNGC")
                .when(xpath("/Order/CustomerID = 'LAZYK'"))
                    .log("LAZYK message")
                    .to("file:target/messages/LAZYK")
                .when(xpath("/Order/CustomerID = 'LETSS'"))
                    .log("LETSS message")
                    .to("file:target/messages/LETSS")
                .otherwise()
                    .log("Other message")
                    .to("file:target/messages/other");
    }

}
