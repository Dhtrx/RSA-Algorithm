package me.dhtrx.cipher;

import me.dhtrx.exceptions.InvalidMessageException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Encipher {


    private final List<PublicKey> allKeys = new ArrayList<>();
    private final List<List<BigInteger>> enciphered;
    private PublicKey publicKey;

    public Encipher(Message message) throws InvalidMessageException {
        this.publicKey = new PublicKey();
        this.enciphered = encipher(message);
    }

    /** It enciphers a (max 128 Characters long) Message with a PublicKey.
     *
     * @param message The message to be enciphered
     * @return The enciphered Message as a List of BigIntegers
     * @throws InvalidMessageException Thrown if the given message contains more than 128 or less than 1 Characters
     */
    public List<List<BigInteger>> encipher(Message message) throws InvalidMessageException {

        List<List<BigInteger>> ret = new ArrayList<>();

        while (message.setMessage()) {
            String stringMessage = message.getMessage();

            if (stringMessage.length() > 128 || stringMessage.length() < 1) {
                throw new InvalidMessageException(message);
            }

            //Map all Characters of String Message to BigInteger to prepare them for encryption
            ret.add( stringMessage
                    .chars()
                    .mapToObj(c -> new BigInteger(String.valueOf(c)))
                    .map(this::encipherHelp)
                    .toList()
            );

            //Save Key and generate new
            this.allKeys.add(this.publicKey);
            this.publicKey = new PublicKey();
        }
        return ret;
    }

    /** The encipher function x -> y = x^e mod n
     *
     * @param x The value to be mapped
     * @return The mapped value
     */
    private BigInteger encipherHelp(BigInteger x) {
        return x.modPow(publicKey.getE(), publicKey.getN());
    }

    //Getter Methods Start
    public List<List<BigInteger>> getEnciphered() {
        return enciphered;
    }

    public List<PublicKey> getAllKeys() {
        return allKeys;
    }
    //Getter Methods End
}
