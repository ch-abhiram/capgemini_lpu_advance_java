package com.prac;



import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    
    public void registerUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userDAO.registerUser(user);
        System.out.println("User registered successfully!");
    }

    
    public User getUser(Long id) {
        return userDAO.getUserById(id);
    }

    
    public List<Post> getPostsByUser(Long userId) {
        return userDAO.getPostsByUser(userId);
    }

    
    public List<Comment> getCommentsByUser(Long userId) {
        return userDAO.getCommentsByUser(userId);
    }
}
