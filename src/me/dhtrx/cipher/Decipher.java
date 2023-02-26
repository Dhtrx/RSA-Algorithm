package me.dhtrx.cipher;

public class Decipher {

    private final PrivateKey privateKey;
    private Message deciphered;

    public Decipher(Encipher encipher) {
        privateKey = new PrivateKey(encipher.getPublicKey());

    }

    /** A method to decipher an enciphered Object and returning it as a message
     *
     * @param encipher The Object to be deciphered
     * @return The deciphered Message
     */
    public Message decipher(Encipher encipher) {

        //todo

        return null;
    }

}
