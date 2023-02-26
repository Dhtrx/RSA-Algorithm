package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message testMessage = new Message(new File("C:\\Users\\Anwender\\IdeaProjects\\RSA Algorithmus\\test\\me\\dhtrx\\TestMessage.txt"));
    Message testMessageLong = new Message(new File("C:\\Users\\Anwender\\IdeaProjects\\RSA Algorithmus\\test\\me\\dhtrx\\TestMessageLong.txt"));

    MessageTest() throws CannotCreateMessageException {
    }

    @Test
    void messageFromFile() {

        Assertions.assertEquals("This is a Message to test the methods messageFromFile and messageAsBlocks from class Message, Project RSA Algorithm.", testMessage.getMessage());

        Assertions.assertThrows(CannotCreateMessageException.class, () -> new Message(new File("C:\\Users\\Anwender\\IdeaProjects\\RSA Algorithmus\\test\\me\\dhtrx\\ThrowTest.txt")));
    }

}