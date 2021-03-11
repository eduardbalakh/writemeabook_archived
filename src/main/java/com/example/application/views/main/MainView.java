package com.example.application.views.main;

import com.example.application.views.about.AboutView;
import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;

import java.util.Optional;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
public class MainView extends AppLayout {

    private final Tabs menu;
    private H1 viewTitle;

    public MainView() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.add(new Avatar());
        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/logo.png", "My Project logo"));
        logoLayout.add(new H1("SCL editor"));
        layout.add(logoLayout, menu);
        return layout;
    }

    private Tabs createMenu() {

        //Tree<TextEntity> projectTreeGrid = new Tree<TextEntity>(TextEntity::getName);

        //projectTreeGrid.addHierarchyColumn(TextEntity::getName);


        /*BookProject bookProject = new BookProject(0, "Fantasy", null);
        Book book = new Book(1, "Final Fantasy XII", bookProject);
        Chapter chapter1 = new Chapter(2, "Chapter 1. Prologue", book);
        Chapter chapter2 = new Chapter(3, "Chapter 2. New mission", book);
        chapter1.setText("Text of chapter 1");
        chapter2.setText("Text of chapter 2");*/
/*        bookProject.getChildren().add(book);
        book.getChildren().add(chapter1);
        book.getChildren().add(chapter2);*/

        /*List<TextEntity> all = Arrays.asList(bookProject, book, chapter1, chapter2);

        all.forEach(p -> projectTreeGrid.getTreeData().addItem(p.getParent(), p));

        Tree<TextEntity> tree = new Tree<>(TextEntity::getName);
        TreeData<TextEntity> treeData = new TreeData<>();

        treeData.addItem(null, bookProject);
        treeData.addItem(bookProject, book);
        treeData.addItem(book, chapter1);
        treeData.addItem(book, chapter2);
        TreeDataProvider<TextEntity> inMemDP = new TreeDataProvider<>(treeData);
        tree.setDataProvider(inMemDP);
        tree.addItemClickListener(event -> Notification.show("Click " + event.getItem().getName()));*/
        //tree.setItems(all, TextEntity::getChildren);
        /*tree.setItems(all, text -> {
            if (text.getChildren().size() > 0 && text.getChildren() != null) {
                return text.getChildren();
            } else {
                return Collections.emptyList();
            }
        });*/

        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        //tabs.add(createMenuItems());
        //tree.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        /*tabs.add(projectTreeGrid);*/
        /*Tab tab = new Tab();
        tab.add(tree);*/
        //tabs.add(tree);
        return tabs;
    }

    private Component[] createMenuItems() {
        return new Tab[]{createTab("Substation 1", HelloWorldView.class), createTab("Substation 2", AboutView.class)};
    }

    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        viewTitle.setText(getCurrentPageTitle());
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}

class Tree<T> extends TreeGrid<T> {
    public Tree(ValueProvider<T, ?> valueProvider) {
        addHierarchyColumn(valueProvider);
    }
}
