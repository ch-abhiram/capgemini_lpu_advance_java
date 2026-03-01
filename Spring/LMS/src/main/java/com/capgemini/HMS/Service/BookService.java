package com.capgemini.HMS.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HMS.Entity.Author;
import com.capgemini.HMS.Entity.Book;
import com.capgemini.HMS.Entity.Category;
import com.capgemini.HMS.Entity.LibraryBranch;
import com.capgemini.HMS.Repository.AuthorRepository;
import com.capgemini.HMS.Repository.BookRepository;
import com.capgemini.HMS.Repository.CategoryRepository;
import com.capgemini.HMS.Repository.LibraryBranchRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookjpa;

    @Autowired
    private CategoryRepository categoryjpa;

    @Autowired
    private LibraryBranchRepository branchjpa;

    @Autowired
    private AuthorRepository authorjpa;

    public Book addBook(Book b, Long categoryId, Long branchId, Set<Long> authorIds) {

        Category category = categoryjpa.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        LibraryBranch branch = branchjpa.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        Set<Author> authors = new HashSet<>(authorjpa.findAllById(authorIds));

        b.setCategory(category);
        b.setBranch(branch);
        b.setAuthors(authors);
        b.setCopiesAvailable(b.getCopiesTotal());
        b.setStatus("ACTIVE");

        return bookjpa.save(b);
    }

    public Book getBookById(Long id) {
        return bookjpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getAllBooks() {
        return bookjpa.findAll();
    }

    public Book updateBook(Long id, Book update) {
        Book obj = getBookById(id);
        obj.setTitle(update.getTitle());
        obj.setIsbn(update.getIsbn());
        obj.setPublishYear(update.getPublishYear());
        obj.setCopiesTotal(update.getCopiesTotal());
        return bookjpa.save(obj);
    }

    public void deleteBook(Long id) {
        Book obj = getBookById(id);
        bookjpa.delete(obj);
    }
}
