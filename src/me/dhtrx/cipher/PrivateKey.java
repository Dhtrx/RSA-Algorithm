package me.dhtrx.cipher;

import java.math.BigInteger;
import java.util.Random;

public class PrivateKey {

    private BigInteger n;
    private BigInteger d;

    public PrivateKey(PublicKey publicKey) {

        n = publicKey.getN();
        BigInteger fn = publicKey.getFn();

        BigInteger e = publicKey.getE();
        //Calculate d and make sure e is invertible
        while (d.equals(BigInteger.ZERO)) {
            d = e.modInverse(fn);
        }

    }

}
