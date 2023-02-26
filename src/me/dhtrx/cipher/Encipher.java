package me.dhtrx.cipher;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Encipher {



    private final List<BigInteger> enciphered;
    private final PublicKey publicKey;

    public Encipher(Message message) {
        enciphered = encipher(message);
        publicKey = new PublicKey();
    }

    public List<BigInteger> encipher(Message message) {

        //todo

        return null;
    }

    private BigInteger encipherHelp(BigInteger x) {
        return x.modPow(publicKey.getE(), publicKey.getN());
    }

    public List<BigInteger> getEnciphered() {
        return enciphered;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
