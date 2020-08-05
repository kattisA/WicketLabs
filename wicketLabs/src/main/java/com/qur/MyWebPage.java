package com.qur;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public abstract class MyWebPage extends WebPage {

    public MyWebPage() {
        add(new BookmarkablePageLink<>("page1", Page1.class));
        add(new BookmarkablePageLink<>("page2", Page2.class));
        add(new NavomaticBorder("navomaticBorder"));
        add(new Label("footer", "This is in the footer"));
    }
}
