package dev.sivzeen.springguruwebapp.repositories;

import dev.sivzeen.springguruwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author siviwe.sisusa
 * Date: 2020/10/28
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
