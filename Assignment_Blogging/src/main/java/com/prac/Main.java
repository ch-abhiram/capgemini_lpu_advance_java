package com.prac;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
        PostService postService = new PostService();
        CommentService commentService = new CommentService();

        userService.registerUser("Abhiram", "abhi@gmail.com", "1234");
        userService.registerUser("Rahul", "rahul@gmail.com", "abcd");

        postService.createPost(1L, "Hibernate Basics", "Understanding JPA mapping");
        postService.createPost(1L, "Spring Boot Intro", "Dependency Injection explained");
        postService.createPost(2L, "Java Streams", "Intermediate operations explained");

        postService.updatePost(1L, "Hibernate Advanced",
                "Unidirectional mapping in depth");

        commentService.addComment(1L, 2L, "Great explanation!");
        commentService.addComment(1L, 1L, "Thanks for reading!");
        commentService.addComment(2L, 2L, "Very helpful post!");

        System.out.println("\nPosts by User 1:");
        List<Post> userPosts = userService.getPostsByUser(1L);
        for (Post p : userPosts) {
            System.out.println("Post ID: " + p.getId() +
                    " | Title: " + p.getTitle() +
                    " | Created At: " + p.getCreatedAt());
        }

        System.out.println("\nComments on Post 1:");
        List<Comment> comments = commentService.getCommentsByPost(1L);
        for (Comment c : comments) {
            System.out.println("Comment ID: " + c.getId() +
                    " | Content: " + c.getContent());
        }

        System.out.println("\nComments written by User 2:");
        List<Comment> userComments = userService.getCommentsByUser(2L);
        for (Comment c : userComments) {
            System.out.println("Comment ID: " + c.getId() +
                    " | Content: " + c.getContent());
        }


        postService.deletePost(3L);

        System.out.println("\nExecution Completed Successfully!");
    }
}