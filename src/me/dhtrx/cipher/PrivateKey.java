package me.dhtrx.cipher;

import java.math.BigInteger;

public class PrivateKey {

    private final BigInteger n;
    private final BigInteger d;

    public PrivateKey(PublicKey publicKey) {

        n = publicKey.getN();
        BigInteger fn = publicKey.getFn();
        BigInteger e = publicKey.getE();

        d = e.modInverse(n);

    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }
}
