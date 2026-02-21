package com.prac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    
    public void createPost(Post post, User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        post.setAuthor(user);
        em.persist(post);
        tx.commit();

        em.close();
    }

    
    public void updatePost(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(post);
        tx.commit();

        em.close();
    }

    
    public void deletePost(Long postId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Post post = em.find(Post.class, postId);
        if (post != null) {
            em.remove(post);
        }
        tx.commit();

        em.close();
    }

    
    public Post getPostById(Long id) {
        EntityManager em = emf.createEntityManager();
        Post post = em.find(Post.class, id);
        em.close();
        return post;
    }

    
    public List<Post> getAllPosts() {
        EntityManager em = emf.createEntityManager();

        List<Post> posts = em.createQuery(
                "SELECT p FROM Post p",
                Post.class)
                .getResultList();

        em.close();
        return posts;
    }

}
