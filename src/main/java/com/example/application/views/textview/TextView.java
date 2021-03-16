package com.example.application.views.textview;

import com.example.application.service.book.BookService;
import com.example.application.service.chapter.ChapterService;
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

/*    @Autowired
    private ProjectService projectService;*/

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
        /*User user = userService.getUser(1);
        BookProject project = user.getBookProjects().get(0);
        Book book1 = new Book("The Fellowship of the Ring", 0, project);
        bookService.saveBook(book1);*/
        /*Book book1 = bookService.getBook(2);
        TextStory textStoryOfChapter1 = textStoryService.getText(1);
        Chapter chapter2 = new Chapter("A Long-expected Party3", 1, textStoryOfChapter1);
        //textStoryService.saveText(textStoryOfChapter1);
        book1.addChapterToBook(chapter2);
        chapterService.saveChapter(chapter2);
        bookService.saveBook(book1);*/

/*        Book book_test = new Book("TestBook1", 0);
        //Book book_test = bookService.getBook(3);
        //TextStory textStory = textStoryService.getText(3);
        TextStory textStory = new TextStory("TEST STORY");
        Chapter chapter_test1 = new Chapter("chapter title 1", 0, textStory);
        book_test.addChapterToBook(chapter_test1);
        //textStoryService.saveText(textStory);
        chapterService.saveChapter(chapter_test1);
        bookService.saveBook(book_test);*/
        bookService.deleteBook(7);


    }

}
