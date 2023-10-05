package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class BookServiceTest {
    /**
     * У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах
     * из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта
     * BookRepository.
     */

    public BookRepository bookRepositoryMock;
    public BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void findBookById() {
        String id = "1";

        Book book = new Book(id, "War and Peace", "Leo Tolstoy");
        when(bookRepositoryMock.findById(id)).thenReturn(book);

        Book foundBook = bookService.findBookById(id);

        assertEquals(book, foundBook);
    }

    @Test
    void findAllBooks() {
        List<Book> allBooks = new ArrayList<>();

        allBooks.add(new Book("1", "War and Peace", " Leo Tolstoy"));
        allBooks.add(new Book("2", "Crime and Punishment", "Fyodor Dostoevsky"));

        when(bookRepositoryMock.findAll()).thenReturn(allBooks);
        List<Book> foundBooks = bookService.findAllBooks();

        assertEquals(allBooks, foundBooks);
    }
}