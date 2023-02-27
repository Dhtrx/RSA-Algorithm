package me.dhtrx.exceptions;

import me.dhtrx.cipher.Message;

public class InvalidMessageException extends Exception{

    public InvalidMessageException(Message message) {
        super("The message " + message + " has more than 128 characters.");
    }

}
