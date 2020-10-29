package dev.sivzeen.springguruwebapp.repositories;

import dev.sivzeen.springguruwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author siviwe.sisusa
 * Date: 2020/10/28
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
