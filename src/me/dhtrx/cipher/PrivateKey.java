package me.dhtrx.cipher;

import java.math.BigInteger;

public class PrivateKey {

    private final BigInteger n;
    private BigInteger d = BigInteger.ZERO;

    public PrivateKey(PublicKey publicKey) {

        n = publicKey.getN();
        BigInteger fn = publicKey.getFn();
        BigInteger e = publicKey.getE();

        //Calculate d and make sure e is invertible
        while (d.equals(BigInteger.ZERO)) {
            d = e.modInverse(fn);
        }

    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }
}
