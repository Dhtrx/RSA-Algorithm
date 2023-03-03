package me.dhtrx.cipher;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

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
    public void decipher(Encipher encipher) throws IOException { //todo

        List<PublicKey> publicKeys = encipher.getAllKeys();
        int numPublicKeys = publicKeys.size();

        List<List<BigInteger>> enciphered = encipher.getEnciphered();
        List<BigInteger> deciphered = new ArrayList<>();

        while(numPublicKeys != 0) {

            for(int i = 0; i < enciphered.size(); i+=2) {

                privateKey = new PrivateKey(publicKeys.get(i));
                publicKeys.remove(i);
                numPublicKeys = publicKeys.size();
                enciphered.get(i--).stream().map(bigInteger -> deciphered.add(new BigInteger(bigInteger.modPow(this.privateKey.getD(), this.privateKey.getN()).toByteArray())));
            }

        }


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
