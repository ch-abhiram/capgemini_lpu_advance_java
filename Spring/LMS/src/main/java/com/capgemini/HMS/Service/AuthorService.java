package com.capgemini.HMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HMS.Entity.Author;
import com.capgemini.HMS.Repository.AuthorRepository;
@Service
public class AuthorService {
	@Autowired
    private AuthorRepository authorjpa;

    public Author addAuthor(Author a) {
        return authorjpa.save(a);
    }

    public Author getAuthorById(Long id) {
        return authorjpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> getAllAuthors() {
        return authorjpa.findAll();
    }

    public Author updateAuthor(Long id, Author update) {
        Author obj = getAuthorById(id);
        obj.setName(update.getName());
        obj.setBiography(update.getBiography());
        return authorjpa.save(obj);
    }

    public void deleteAuthor(Long id) {
        Author obj = getAuthorById(id);
        authorjpa.delete(obj);
    }
	
	

}
