package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;

import java.io.*;

public class Message {

    private String message;
    private StringBuilder fromInput = new StringBuilder();

    /**Constructor to read a Message from a File
     *
     * @param input The File containing the Message
     * @throws CannotCreateMessageException Throws if File is Empty
     */
    public Message(File input) throws CannotCreateMessageException {

        this.fromInput = messageFromFile(input);

    }

    /** Constructor to save a deciphered Message
     *
     * @param message The message to be saved
     */
    public Message(String message) throws IOException {

        this.message = message;
        saveMessage(message);


    }

    public String getMessage() {

        assert message != null;
        return message;

    }

    public StringBuilder getFromInput() {
        return fromInput;
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

    /** It splits the input File into Blocks of max. 128 characters
     *
     * @return Max. 128 characters of the input File
     */
    public boolean setMessage() {

        if (this.fromInput.isEmpty()) {

            return false;

        } else if (this.fromInput.length() <= 128) {

            this.message = this.fromInput.toString();
            this.fromInput = new StringBuilder();

            return true;
        } else {

            this.message = this.fromInput.substring(0, 128);
            this.fromInput.delete(0, 128);

            return true;

        }

    }

    /** Writes a deciphered Message to a Txt File
     *
     * @param message The deciphered Message
     * @throws IOException Throws if File can not be created
     */
    private void saveMessage(String message) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./DecipheredMessage.txt"));
        writer.write(message);
        writer.close();

    }

}
