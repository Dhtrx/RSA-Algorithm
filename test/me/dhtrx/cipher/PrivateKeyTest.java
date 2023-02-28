package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;
import me.dhtrx.exceptions.InvalidMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PrivateKeyTest {

    @Test
    void testKeySystem() throws IOException, InvalidMessageException, CannotCreateMessageException {

        PublicKey testPub = new PublicKey();
        PrivateKey test = new PrivateKey(testPub);

        Message testKeys = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\Test7.txt"));
        Encipher testKeyEncipher = new Encipher(testKeys);
        Decipher testKeyDecipher = new Decipher(testKeyEncipher);

        Assertions.assertEquals("7", new BufferedReader(new FileReader("./DecipheredMessage.txt")).readLine());

    }

}