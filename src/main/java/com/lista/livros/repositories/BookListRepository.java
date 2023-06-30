package com.lista.livros.repositories;


import com.lista.livros.models.BookListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<BookListModel, Long> { //Deve-se dar extend dessa interface no JpaRepository para habilitar os métodos.
//O Spring tem alguns estereótipos q definem q uma determinada classe é um bean, responsável pelo gerenciamento.
// Tornando possível utilizar da inversão de controle com a injeção de dependência.
//São 4 estereótipos: @Component (classe mais genérica); @Service,
//@Repository(mostra q a classe q fará transação com o db e o @Controller (onde ficam os endpoints).

}
