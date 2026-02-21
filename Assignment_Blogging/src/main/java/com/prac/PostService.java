package com.prac;

import java.time.LocalDateTime;
import java.util.List;

public class PostService {

    private PostDAO postDAO = new PostDAO();
    private UserDAO userDAO = new UserDAO();

    
    public void createPost(Long userId, String title, String content) {

        User user = userDAO.getUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        postDAO.createPost(post, user);

        System.out.println("Post created successfully!");
    }

    
    public void updatePost(Long postId, String newTitle, String newContent) {

        Post post = postDAO.getPostById(postId);

        if (post == null) {
            System.out.println("Post not found!");
            return;
        }

        post.setTitle(newTitle);
        post.setContent(newContent);
        post.setUpdatedAt(LocalDateTime.now());

        postDAO.updatePost(post);

        System.out.println("Post updated successfully!");
    }

    
    public void deletePost(Long postId) {
        postDAO.deletePost(postId);
        System.out.println("Post deleted successfully!");
    }

    
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }
}