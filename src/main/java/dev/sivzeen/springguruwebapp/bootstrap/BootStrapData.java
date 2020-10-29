package dev.sivzeen.springguruwebapp.bootstrap;

import dev.sivzeen.springguruwebapp.domain.Author;
import dev.sivzeen.springguruwebapp.domain.Book;
import dev.sivzeen.springguruwebapp.domain.Publisher;
import dev.sivzeen.springguruwebapp.repositories.AuthorRepository;
import dev.sivzeen.springguruwebapp.repositories.BookRepository;
import dev.sivzeen.springguruwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author siviwe.sisusa
 * Date: 2020/10/28
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher dddPublisher = new Publisher("O'Reilly Books", "112 George Street", "Cape Town", "Western Cape", "8000");
        publisherRepository.save(dddPublisher);

        Publisher springPublisher = new Publisher("Springer Books", "19 Monument Street", "George", "Western Cape", "7140");
        publisherRepository.save(springPublisher);

        //Book and Author One
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "124563");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(dddPublisher);
        dddPublisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(dddPublisher);

        //Book and Author 2
        Author rod = new Author("Rod", "Johnson");
        Book springBook = new Book("Spring Development", "98745623");
        rod.getBooks().add(springBook);
        springBook.getAuthors().add(rod);

        springBook.setPublisher(springPublisher);
        springPublisher.getBooks().add(springBook);

        authorRepository.save(rod);
        bookRepository.save(springBook);
        publisherRepository.save(springPublisher);

        System.out.println("Stared bootstrap....");
        System.out.println("Number of books added -> " +  bookRepository.count());

        System.out.println("Number of Book Publishers -> "+ publisherRepository.count());
        System.out.println("Number of Books published my DDD publisher: "+ dddPublisher.getBooks().size());
    }
}
