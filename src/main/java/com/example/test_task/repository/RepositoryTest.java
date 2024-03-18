package com.example.test_task.repository;

import com.example.test_task.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Book> findOrderedBy(String column, String sort) {
        return entityManager.createQuery("SELECT b FROM Book b ORDER BY b."+column+" "+sort,
                Book.class).setMaxResults(10).getResultList();
    }

    public List<Book> findOrderedByWithYear(String column, String sort, int year) {
        return entityManager.createQuery("SELECT b FROM Book b where YEAR (b.publicationDate) = "+ year + " ORDER BY b."+column+" "+sort,
                Book.class).setMaxResults(10).getResultList();
    }
}
