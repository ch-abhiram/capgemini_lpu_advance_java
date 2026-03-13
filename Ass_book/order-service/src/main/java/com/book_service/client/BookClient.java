package com.book_service.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book_service.dto.BookDTO;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/api/books/{id}")
    BookDTO getBookById(@PathVariable Long id);

}
