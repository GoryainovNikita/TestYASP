package com.example.test_task.api;

import com.example.test_task.model.Book;
import com.example.test_task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/top10")
    public List<Book> getTop10(@RequestParam("column") String column,
                               @RequestParam("sort") String sort,
                               @RequestParam(value = "year", required = false) Optional<Integer> year){
        if(year.isEmpty()){
            return bookService.findBook(column, sort);
        }
        else {
            return bookService.findBookWithYear(column, sort, year.get());
        }
    }
    @GetMapping("/top11")
    public String getTop11(){

        return "Hello";
    }


}
