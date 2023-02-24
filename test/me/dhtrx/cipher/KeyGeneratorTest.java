package me.dhtrx.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KeyGeneratorTest {

    @BeforeAll
    static void constructorTest() {
        for (int i = 100; i > 0; i--) {
            Assertions.assertDoesNotThrow(KeyGenerator::new);
        }
    }

    @Test
    void getD() {

    }
}