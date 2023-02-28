package me.dhtrx.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivateKeyTest {

    @Test
    void testConstructor() {

        PublicKey testPub = new PublicKey();
        PrivateKey test = new PrivateKey(testPub);

    }

}