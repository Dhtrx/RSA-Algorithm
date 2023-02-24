package me.dhtrx.cipher;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
    private final BigInteger p;
    private BigInteger q;
    private final BigInteger n;
    private final BigInteger fn;
    private BigInteger e;
    private BigInteger d = BigInteger.ZERO;


    public KeyGenerator() {

        //Generate two prime numbers p, q in N with p != q
        p = BigInteger.probablePrime(512, new Random(seed()));
        q = BigInteger.probablePrime(512, new Random(seed()));
        while (q.equals(p)) {
            q = BigInteger.probablePrime(512, new Random(seed()));
        }

        //Calculate n = pq and f(n) = (p - 1)(q - 1)
        n = p.multiply(q);
        fn = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        //Generate e in N with 1 < e < fn
        e = new BigInteger(fn.bitLength(), new Random(seed()));
        while(!e.gcd(fn).equals(BigInteger.ONE) && e.compareTo(fn) != -1) {
            e = new BigInteger(fn.bitLength(), new Random(seed()));
        }

        //Calculate d and make sure e is invertible
        while (d.equals(BigInteger.ZERO)) {
            try {
                d = e.modInverse(fn);
            } catch (ArithmeticException exception) {
                e = new BigInteger(fn.bitLength(), new Random(seed()));
            }
        }
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    /**
     * It returns a random number between 0 and Long.MAX_VALUE
     *
     * @return A random number between 0 and Long.MAX_VALUE
     */
    private long seed() {
        long range = Long.MAX_VALUE;
        Random r = new Random();
        return (long) (r.nextDouble() * range);
    }
}
