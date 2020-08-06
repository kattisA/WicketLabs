package com.qur;

import org.apache.wicket.markup.html.basic.Label;

public class HelloWorld extends MyWebPage {

    public HelloWorld(){
       queue(new Label("message", "Hello World!"));
    }

}
