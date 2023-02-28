package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message testMessage = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessage.txt"));
    Message testMessageLong = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessageLong.txt"));

    MessageTest() throws CannotCreateMessageException {
    }

    @Test
    void messageFromFile() {

        Assertions.assertEquals("This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm.", testMessage.getFromInput().toString());
        Assertions.assertEquals("This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm. This is the version with more than 128 symbols.", testMessageLong.getFromInput().toString());

        Assertions.assertThrows(CannotCreateMessageException.class, () -> new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\ThrowTest.txt")));

    }

    @Test
    void setMessage() {

        testMessage.setMessage();
        Assertions.assertEquals("This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm.", testMessage.getMessage());

        testMessageLong.setMessage();
        Assertions.assertEquals("This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm. This is the", testMessageLong.getMessage());
        testMessageLong.setMessage();
        Assertions.assertEquals(" version with more than 128 symbols.", testMessageLong.getMessage());
    }

    @Test
    void saveMessage() throws IOException {

        Message testSave = new Message("This is to test the saveMessage method");
        Assertions.assertEquals(new BufferedReader(new FileReader("./DecipheredMessage.txt")).readLine(), "This is to test the saveMessage method");

        Message testSave2 = new Message("This is also to test the save Message method");
        Assertions.assertEquals(new BufferedReader(new FileReader("./DecipheredMessage.txt")).readLine(), "This is also to test the save Message method");

    }

}