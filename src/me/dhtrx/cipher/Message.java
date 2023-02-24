package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Message {

    private final String message;
    private List<String> messageBlocks;
    private final File input;

    public Message(File input) throws CannotCreateMessageException {
        this.input = input;
        this.message = messageFromFile(input);
        if (message.length() > 128) {
            this.messageBlocks = messageAsBlocks(this.message);
        }
    }



    public String getMessage() {
        return message;
    }

    public List<String> getMessageBlocks() {
        return messageBlocks;
    }

    public File getInput() {
        return input;
    }

    /**
     * It reads a file and returns the contents of the file as a string
     *
     * @param file The file to read from
     * @return A string
     * @throws CannotCreateMessageException Thrown if return statement in try can not be re
     */
    private String messageFromFile(File file) throws CannotCreateMessageException{

        //Read from file and copy in return String if possible
        StringBuilder ret = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                ret.append(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Return String if not empty else throw Exception
        if (ret.isEmpty()) {
            throw new CannotCreateMessageException(file);
        } else {
            return ret.toString();
        }
    }

    /**
     * It takes a string and returns a list of strings, each of which is 128 characters long
     * (The max size of characters that can be enciphered with one n)
     * @param message The message to be encrypted.
     * @return A list of strings, each string is a block of 128 characters.
     */
    private List<String> messageAsBlocks(String message) {

        List<String> ret = new ArrayList<>();

        int i = 0;
        int j = 64;
        StringBuilder adding = new StringBuilder();
        while(i < message.length()) {
            while (i < j * 2 && i < message.length()) {
                adding.append(message.charAt(i));
                i++;
            }
            ret.add(adding.toString());
            adding = new StringBuilder();
            j *= 2;
        }
        return ret;
    }

}
