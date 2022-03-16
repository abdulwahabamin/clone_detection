public byte[] encrypt(byte[] message) throws Exception
{
    //AlgorithmParameterSpec spec = new IvParameterSpec(cipher.getIV());
    cipher.init(Cipher.ENCRYPT_MODE, key,ivspec);

    return cipher.doFinal(message);
}

