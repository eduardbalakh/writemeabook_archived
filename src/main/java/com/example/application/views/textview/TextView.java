package com.example.application.views.textview;

import com.example.application.service.book.BookService;
import com.example.application.service.chapter.ChapterService;
import com.example.application.service.project.ProjectService;
import com.example.application.service.textstory.TextStoryService;
import com.example.application.service.user.UserService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class TextView extends VerticalLayout {

   @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private TextStoryService textStoryService;

    @Autowired
    private ChapterService chapterService;

    private Button addNewTextArea;
    private RichTextEditor textArea;

    public TextView() {
        addClassName("hello-world-view");
        setWidthFull();
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        addNewTextArea = new Button("Сохранить");
        textArea = new RichTextEditor();
        textArea.setWidthFull();
        layout.add(addNewTextArea, textArea);
        textArea.setValue("AAAAAAAAAAA");
        add(layout);

        /*setHorizontalComponentAlignment(Alignment.CENTER,
                addNewTextArea, textArea);*/
        addNewTextArea.addClickListener(e -> {
            saveToDB(layout);
        });
    }

    private void saveToDB(VerticalLayout layout) {

        getData();

        //List<User> list = userService.getAllUsers();
        //textArea.setValue("list.stream().map(BookProject::toString).collect(Collectors.joining())");
    }

    private void getData() {

/*        User user = userService.getUser(1);
        BookProject project = new BookProject("TestProject1",1, user);
        Book book_test = new Book("TestBook1", 1, project);
        Chapter chapter1 = new Chapter("testchapter1", 0, null, book_test);
        TextStory textStory1 = new TextStory("textStory1");
        Section section1OfChapter1 = new Section("testSection1", 0, textStory1, chapter1);
        TextStory textStory2 = new TextStory("textStory2");
        Section section2OfChapter1 = new Section("testSection2", 0, textStory2, chapter1);
        TextStory textStory3 = new TextStory("textStory3");
        Chapter chapter2 = new Chapter("testchapter2", 1, textStory3, book_test);

        userService.saveUser(user);*/

        projectService.deleteProject(4);




    }

}
