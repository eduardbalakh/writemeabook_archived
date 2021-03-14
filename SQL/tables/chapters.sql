CREATE TABLE book_projects.chapters (
    id int not null auto_increment,
    title varchar(100),
    num_order int,
    book_id int,
    text_id int,
    PRIMARY KEY (id),
    foreign key (book_id) references book_projects.books(id),
    foreign key (text_id) references book_projects.stories(id)
    );