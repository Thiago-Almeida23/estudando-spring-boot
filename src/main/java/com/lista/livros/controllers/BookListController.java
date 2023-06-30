package com.lista.livros.controllers;

import com.lista.livros.dto.BookListDto;
import com.lista.livros.models.BookListModel;
import com.lista.livros.repositories.BookListRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Anotação mais específica que varia da @Controller.
public class BookListController {

    @Autowired//Indica que essa instância (no caso Repository) precisa ser usada nessa propriedade, aqui embaixo.
    BookListRepository bookListRepository;

    @PostMapping("/books")
    public ResponseEntity<BookListModel> saveBook(@RequestBody @Valid BookListDto bookListDto){
        var bookListModel = new BookListModel();
        BeanUtils.copyProperties(bookListDto, bookListModel);//O BeanUtils é um método que recebe o q será convertido e o tipo da conversão(DTO em Model).
        return ResponseEntity.status(HttpStatus.CREATED).body(bookListRepository.save(bookListModel));
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookListModel>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookListRepository.findAll());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getOneBook(@PathVariable(value = "id") Long id){
        Optional<BookListModel> bookO = bookListRepository.findById(id);
        if(bookO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookO.get());
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value = "id")Long id,
                                      @RequestBody @Valid BookListDto bookListDto) {
        Optional<BookListModel> bookO = bookListRepository.findById(id);
        if (bookO.isEmpty()) {
            return
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        var bookListModel = bookO.get();
        BeanUtils.copyProperties(bookListDto, bookListModel);
        return ResponseEntity.status(HttpStatus.OK).body(bookListRepository.save(bookListModel));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") Long id){
        Optional<BookListModel> bookO = bookListRepository.findById(id);
        if (bookO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
        }
        bookListRepository.delete(bookO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
    }
}
