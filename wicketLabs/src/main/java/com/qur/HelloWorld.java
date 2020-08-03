package com.qur;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import java.awt.*;

public class HelloWorld extends WebPage {

    public HelloWorld(){
        add(new Label("message", "Hello World!"));
    }

}
