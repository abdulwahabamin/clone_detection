public byte[] decrypt(byte[] encMessage) throws Exception
{
    
    cipher.init(Cipher.DECRYPT_MODE, key,ivspec);
     //IvParameterSpec iv = new IvParameterSpec(cipher.getIV());
    return cipher.doFinal(encMessage);
}

