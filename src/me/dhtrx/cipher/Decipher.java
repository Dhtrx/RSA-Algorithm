package me.dhtrx.cipher;

import me.dhtrx.exceptions.NotEnoughKeysException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Decipher {

    private final List<KeyGenerator> allKeys;
    private Message deciphered;

    public Decipher(Encipher encipher) {
        this.allKeys = encipher.getAllKeys();

    }

    /** A method to decipher an enciphered Object and returning it as a message
     *
     * @param encipher The Object to be deciphered
     * @return The deciphered Message
     * @throws NotEnoughKeysException Throws if, for whatever reason, allKeys and enciphered differ in size
     */
    public Message decipher(Encipher encipher) throws NotEnoughKeysException {

        List<BigInteger> enciphered = encipher.getEnciphered();
        List<String> ret = new ArrayList<>();

        if(allKeys.size() != enciphered.size()) {
            throw new NotEnoughKeysException(allKeys, enciphered);
        }

        for (int i = 0; i < enciphered.size(); i++) {

            BigInteger curKey = allKeys.get(i).getD();
            BigInteger curN = allKeys.get(i).getN();
            BigInteger curEnciphered = enciphered.get(i);

            BigInteger decipher = curEnciphered.modPow(curKey, curN);

            //How to get back to ASCII letters from one BigInteger consisting of ASCII Letters?

        }
        return null;
    }

}
