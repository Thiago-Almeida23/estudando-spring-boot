package com.lista.livros.models;

import jakarta.persistence.*;

@Entity//Informa que uma classe também é uma entidade. Assim, o JPA estabelecerá a ligação entre ela e uma tabela no db.
@Table(name = "TB_BOOKS")// Necessário passar o nome da tabela.
public class BookListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//com o AUTO, sempre que um recurso for salvo na db, os Ids serão gerados automaticamente.
    private Long idBook;
    private String name;
    private String writer;
    private String publisher;
    private String year;
    private String finished;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }
}
