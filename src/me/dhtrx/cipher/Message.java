package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Message {

    private final String message;
    private final File input;

    public Message(File input) throws CannotCreateMessageException {
        this.input = input;
        this.message = messageFromFile(input);
    }



    public String getMessage() {
        return message;
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

}
