package com.example.application.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends VerticalLayout {

    private Button addNewTextArea;
    private RichTextEditor textArea;

    public HelloWorldView() {
        addClassName("hello-world-view");
        setWidthFull();
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        addNewTextArea = new Button("Сохранить");
        textArea = new RichTextEditor();
        textArea.setWidthFull();
        layout.add(addNewTextArea, textArea);
        add(layout);

        /*setHorizontalComponentAlignment(Alignment.CENTER,
                addNewTextArea, textArea);*/
        addNewTextArea.addClickListener(e -> {
            saveToDB(layout);
        });
    }

    private void saveToDB(VerticalLayout layout) {

    }

}
