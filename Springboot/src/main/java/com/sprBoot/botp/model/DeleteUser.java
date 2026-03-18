package com.sprBoot.botp.model;

 
public class DeleteUser {
    private String message;
    private User user;


	public DeleteUser(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser () {
        return user;
    }
}