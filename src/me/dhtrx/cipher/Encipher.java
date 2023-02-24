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

        List<String> messageList = message.getMessageBlocks();
        List<BigInteger> ret = new ArrayList<>();

        for (String s : messageList) {
            Stream<BigInteger> messageStream = s.chars().mapToObj(character -> new BigInteger(String.valueOf(character)));
            messageStream.map(x -> x.modPow(key.getE(), key.getN())).forEach(ret::add);
            allKeys.add(key);
            key = new KeyGenerator();
        }
        return ret;
    }

    public List<KeyGenerator> getAllKeys() {
        return allKeys;
    }

    public List<BigInteger> getEnciphered() {
        return enciphered;
    }
}
