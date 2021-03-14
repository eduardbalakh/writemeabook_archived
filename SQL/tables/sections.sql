CREATE TABLE book_projects.sections (
    id int not null auto_increment,
    title varchar(100),
    num_order int,
    chapter_id int,
    text_id int,
    PRIMARY KEY (id),
    foreign key (chapter_id) references book_projects.chapters(id),
    foreign key (text_id) references book_projects.stories(id)
    );