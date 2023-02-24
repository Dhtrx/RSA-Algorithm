package me.dhtrx.exceptions;

import java.io.File;

public class CannotCreateMessageException extends Exception{
    public CannotCreateMessageException(File file) {
        super("Unable to create me.dhtrx.cipher.Message from File: " + file + " is possibly Empty");
    }
}
