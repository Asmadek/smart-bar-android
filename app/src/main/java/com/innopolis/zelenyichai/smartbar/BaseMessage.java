package com.innopolis.zelenyichai.smartbar;

import java.io.Serializable;

public class BaseMessage implements Serializable{
    String message;
    String sender;

    public int getGetImageId() {
        return getImageId;
    }

    public void setGetImageId(int getImageId) {
        this.getImageId = getImageId;
    }

    public int getImageId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
