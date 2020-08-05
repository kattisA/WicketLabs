package com.qur;

import org.apache.wicket.markup.html.WebPage;

public abstract class MyWebPage extends WebPage {

    public MyWebPage() {
        add(new NavomaticBorder("navomaticBorder"));
    }
}
