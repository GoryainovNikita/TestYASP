package com.example.test_task.service;

import com.example.test_task.model.Book;
import com.example.test_task.model.BookCSV;
import com.example.test_task.repository.BookRepository;
import com.example.test_task.repository.RepositoryTest;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final RepositoryTest repositoryTest;

    @PostConstruct
    public void init(){
        try {
            CsvToBean build = new CsvToBeanBuilder(new FileReader("src\\main\\resources\\books.csv")).withType(BookCSV.class).build();
            Iterator<BookCSV> iterator = build.iterator();
            while (iterator.hasNext()){
                BookCSV bookCSV = iterator.next();
                Book book = ConverterBookCSVToBook.toBook(bookCSV);
                bookRepository.save(book);
                System.out.println(book);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findBook(String column, String sort){
        if(!sort.equalsIgnoreCase("asc") && !sort.equalsIgnoreCase("desc")){
            throw new IllegalArgumentException("Invalid sort");
        }
        return repositoryTest.findOrderedBy(column, sort);
    }

    public List<Book> findBookWithYear(String column, String sort, int year){
        return repositoryTest.findOrderedByWithYear(column, sort, year);
    }

}
