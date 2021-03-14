CREATE TABLE book_projects.subsections (
    id int not null auto_increment,
    title varchar(100),
    num_order int,
    section_id int,
    text_id int,
    PRIMARY KEY (id),
    foreign key (section_id) references book_projects.sections(id),
    foreign key (text_id) references book_projects.stories(id)
    );