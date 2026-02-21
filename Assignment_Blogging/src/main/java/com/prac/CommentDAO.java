package com.prac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CommentDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    
    public void addComment(Comment comment, Post post, User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        comment.setPost(post);
        comment.setAuthor(user);
        em.persist(comment);
        tx.commit();

        em.close();
    }

    
    public Comment getCommentById(Long id) {
        EntityManager em = emf.createEntityManager();
        Comment comment = em.find(Comment.class, id);
        em.close();
        return comment;
    }

    
    public List<Comment> getCommentsByPost(Long postId) {
        EntityManager em = emf.createEntityManager();

        List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.post.id = :pid",
                Comment.class)
                .setParameter("pid", postId)
                .getResultList();

        em.close();
        return comments;
    }

}
