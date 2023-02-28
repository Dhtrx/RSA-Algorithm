package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;
import me.dhtrx.exceptions.InvalidMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import static org.junit.jupiter.api.Assertions.*;

class DecipherTest {

    Message test = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessage.txt"));
    Message testLong = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessageLong.txt"));
    Encipher testEncipher = new Encipher(test);
    Encipher testLongEncipher = new Encipher(testLong);

    DecipherTest() throws InvalidMessageException, CannotCreateMessageException {
    }

    @Test
    void decipher() throws IOException { //failed todo

        Decipher testDecipher = new Decipher(testEncipher);
        Assertions.assertEquals(
                "This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm.",
                new BufferedReader(new FileReader("./DecipheredMessage.txt")).readLine()
        );

        Decipher testLongDecipher = new Decipher(testLongEncipher);
        Assertions.assertEquals(
                "This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm. This is the version with more than 128 symbols.",
                new BufferedReader(new FileReader("./DecipheredMessage.txt")).readLine()
        );


    }
}