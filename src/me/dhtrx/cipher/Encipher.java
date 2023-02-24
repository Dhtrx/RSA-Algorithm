package me.dhtrx.cipher;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Encipher {

    private final List<BigInteger> enciphered;
    private KeyGenerator key;
    private final List<KeyGenerator> allKeys = new ArrayList<>();

    public Encipher(Message message) {
        enciphered = encipher(message);
        key = new KeyGenerator();
    }

    public List<BigInteger> encipher(Message message) {

        List<BigInteger> ret = new ArrayList<>();

        if (message.getMessageBlocks() != null) {

            List<String> messageList = message.getMessageBlocks();


            for (String s : messageList) {
                ret.add(encipherHelp(new BigInteger(message.getMessage())));
                key = new KeyGenerator();
            }
        } else {
            ret.add(encipherHelp(new BigInteger(message.getMessage())));
        }
        return ret;
    }

    private BigInteger encipherHelp(BigInteger x) {
        x = x.modPow(key.getE(), key.getN());
        allKeys.add(key);
        return x;
    }

    public List<KeyGenerator> getAllKeys() {
        return allKeys;
    }

    public List<BigInteger> getEnciphered() {
        return enciphered;
    }
}
