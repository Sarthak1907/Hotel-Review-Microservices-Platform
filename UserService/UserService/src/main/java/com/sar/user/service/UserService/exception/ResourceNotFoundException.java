package com.sar.user.service.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{

    //extra property you want to manage.
    public ResourceNotFoundException(){
        super("Resource Not Found on Server!!!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
