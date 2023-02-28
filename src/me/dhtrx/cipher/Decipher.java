package me.dhtrx.cipher;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Decipher {

    private PrivateKey privateKey;

    public Decipher(Encipher encipher) throws IOException {

        this.privateKey = new PrivateKey(encipher.getAllKeys().get(0));
        decipher(encipher);

    }

    /**
     * A method to decipher an enciphered Object and returning it as a message
     *
     * @param encipher The Object to be deciphered
     */
    public void decipher(Encipher encipher) throws IOException {

        List<PublicKey> publicKeys = encipher.getAllKeys();
        int numPublicKeys = publicKeys.size();

        List<List<BigInteger>> enciphered = encipher.getEnciphered();

        while(numPublicKeys != 0) {

            for(int i = 0; i < enciphered.size(); i++) {

                privateKey = new PrivateKey(publicKeys.get(i));
                publicKeys.remove(i);
                numPublicKeys = publicKeys.size();
                enciphered.get(i).stream().map(bigInteger -> bigInteger.modPow(this.privateKey.getD(), this.privateKey.getN()));

            }

        }

        List<BigInteger> deciphered = enciphered.stream().flatMap(Collection::stream).toList();
        List<Character> decipheredMessage = new ArrayList<>();
        deciphered.stream().map(bigInteger -> {
            int integer = Integer.parseInt(bigInteger.toString());
            decipheredMessage.add((char) integer);
            return integer;
        });

        String message = Arrays.toString(decipheredMessage.toArray());
        new Message(message);
    }

}
