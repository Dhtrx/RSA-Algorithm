package me.dhtrx.cipher;

import me.dhtrx.exceptions.CannotCreateMessageException;
import me.dhtrx.exceptions.InvalidMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EncipherTest {

    Message test = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessage.txt"));
    Message testLong = new Message(new File(System.getProperty("user.dir") + "\\test\\me\\dhtrx\\TestMessageLong.txt"));

    EncipherTest() throws CannotCreateMessageException {
    }

    @Test
    void encipher() throws InvalidMessageException {

        Encipher testEncipher = new Encipher(test);
        Encipher testLongEncipher =new Encipher(testLong);

        assertEquals(1, testEncipher.getAllKeys().size());
        assertEquals(2, testLongEncipher.getAllKeys().size());

    }
}