package me.dhtrx.cipher;

import java.math.BigInteger;
import java.util.Random;

public class PublicKey {

    private final BigInteger n;
    private BigInteger e;
    private final BigInteger fn;

    @SuppressWarnings("All")
    public PublicKey() {

        //Generate two prime numbers p, q in N with p != q
        BigInteger p = BigInteger.probablePrime(512, new Random(seed()));
        BigInteger q = BigInteger.probablePrime(512, new Random(seed()));
        while (q.equals(p)) {
            q = BigInteger.probablePrime(512, new Random(seed()));
        }

        //Calculate n = pq and f(n) = (p - 1)(q - 1)
        n = p.multiply(q);
        fn = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        //Generate e in N with 1 < e < fn and make sure e is invertible
        do {

            e = new BigInteger(fn.bitLength(), new Random(seed()));
            while (!e.gcd(fn).equals(BigInteger.ONE) && e.compareTo(fn) != -1) {
                e = new BigInteger(fn.bitLength(), new Random(seed()));
            }
        } while(!isInvertible(e));
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getFn() {
        return fn;
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

    /** It checks if a BigInteger is modular invertible to fn
     *
     * @param e Ther number to be checked for invertibility
     * @return Wheter e is invertible or not
     */
    @SuppressWarnings("All")
    private boolean isInvertible(BigInteger e) {
        try {
            e.modInverse(this.fn);
            return true;
        } catch (ArithmeticException exception) {
            return false;
        }
    }
}
