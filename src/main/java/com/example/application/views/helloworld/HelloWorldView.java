package com.example.application.views.helloworld;

import com.example.application.model.BookProject;
import com.example.application.model.Role;
import com.example.application.model.User;
import com.example.application.service.ProjectService;
import com.example.application.service.UserService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends VerticalLayout {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

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

        generateData();

        List<BookProject> list = projectService.getAllProjects();
        textArea.setValue(list.stream().map(BookProject::toString).collect(Collectors.joining()));
    }

    private void generateData() {
        User user = new User(Role.ADMIN);
        BookProject project = new BookProject(user, "Lord of the Rings", 1);
        user.addBookProject(project);

        userService.saveUser(user);
        projectService.saveProject(project);
    }

}
