package com.prac;

import java.time.LocalDateTime;
import java.util.List;

public class CommentService {

    private CommentDAO commentDAO = new CommentDAO();
    private PostDAO postDAO = new PostDAO();
    private UserDAO userDAO = new UserDAO();

    
    public void addComment(Long postId, Long userId, String content) {

        Post post = postDAO.getPostById(postId);
        User user = userDAO.getUserById(userId);

        if (post == null || user == null) {
            System.out.println("Post or User not found!");
            return;
        }

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());

        commentDAO.addComment(comment, post, user);

        System.out.println("Comment added successfully!");
    }

    
    public List<Comment> getCommentsByPost(Long postId) {
        return commentDAO.getCommentsByPost(postId);
    }
}