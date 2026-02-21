package com.prac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	public void registerUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(user);
        tx.commit();

        em.close();
    }

    public User getUserById(Long id) {
    	EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public List<Post> getPostsByUser(Long userId) {
    	EntityManager em = emf.createEntityManager();

        List<Post> posts = em.createQuery(
                "SELECT p FROM Post p WHERE p.author.id = :uid",
                Post.class)
                .setParameter("uid", userId)
                .getResultList();

        em.close();
        return posts;
    }

    public List<Comment> getCommentsByUser(Long userId) {
    	EntityManager em = emf.createEntityManager();

        List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.author.id = :uid",
                Comment.class)
                .setParameter("uid", userId)
                .getResultList();

        em.close();
        return comments;
    }


}
