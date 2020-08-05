package com.qur;


import org.apache.commons.lang.StringUtils;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.value.ValueMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GuestBook extends MyWebPage {

    private static final List<Comment> commentList = Collections.synchronizedList(new ArrayList<Comment>());

    public GuestBook(){
        queue(new CommentForm("commentForm"));

        queue(new PropertyListView<Comment>("comments", commentList){
            @Override
            protected void populateItem(ListItem<Comment> listItem) {
                listItem.add(new Label( "date"));
                listItem.add(new MultiLineLabel("text"));
            }
        }).setVersioned(false);

    }

    private static class CommentForm extends Form<ValueMap> {
        public CommentForm(final String id) {
            super(id, new CompoundPropertyModel<>(new ValueMap()));

            setMarkupId("commentForm");

            add(new TextArea<String>("text").setType(String.class));
            add(new TextField<String>("comment").setType(String.class));
        }

        @Override
        public final void onSubmit(){
            ValueMap values = getModelObject();

            if (StringUtils.isNotBlank((String)values.get("comment")))
            {
                error("Caught a spammer!!!");
                return;
            }

            Comment comment = new Comment();
            comment.setDate(new Date());
            comment.setText((String)values.get("text"));
            commentList.add(0, comment);

            values.put("text", "");
        }
    }

    public static void clear() {
        commentList.clear();
    }
}
