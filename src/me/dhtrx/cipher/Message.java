package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Message {

    private String message;
    private final File input;

    private StringBuilder fromInput;

    public Message(File input) throws CannotCreateMessageException {

        this.input = input;
        this.fromInput = messageFromFile(input);

    }

    public String getMessage() {

        assert message != null;
        return message;

    }

    /**
     * It reads a file and returns the contents of the file as a string
     *
     * @param file The file to read from
     * @return A string
     * @throws CannotCreateMessageException Thrown if return statement in try can not be re
     */
    private StringBuilder messageFromFile(File file) throws CannotCreateMessageException{

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
            return ret;
        }
    }

    public boolean setMessage() {

        if (this.fromInput.isEmpty()) {

            return false;

        } else if (this.fromInput.length() <= 128) {

            this.message = this.fromInput.toString();
            this.fromInput = null;

            return true;
        } else {

            this.message = this.fromInput.substring(0, 128);
            this.fromInput.delete(0, 128);

            return true;

        }

    }

}
