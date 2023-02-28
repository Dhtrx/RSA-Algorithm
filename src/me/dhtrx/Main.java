package me.dhtrx;

import me.dhtrx.cipher.Decipher;
import me.dhtrx.cipher.Encipher;
import me.dhtrx.cipher.Message;
import me.dhtrx.exceptions.InvalidMessageException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidMessageException, IOException {

        Message test = new Message("C:\\Users\\Anwender\\IdeaProjects\\RSA Algorithmus\\test\\me\\dhtrx\\TestMessage.txt");
        Encipher testE = new Encipher(test);
        Decipher testD = new Decipher(testE);

    }
}