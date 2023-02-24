package me.dhtrx.exceptions;

import me.dhtrx.cipher.KeyGenerator;

import java.math.BigInteger;
import java.util.List;

public class NotEnoughKeysException extends Exception{

    public NotEnoughKeysException(List<KeyGenerator> keys, List<BigInteger> bigIntegers) {
        super("Key list " + keys + " and encipheredMessage List " + bigIntegers + " differ in size");
    }

}
