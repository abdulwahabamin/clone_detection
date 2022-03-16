    private static byte[] convert(Cipher cipher, byte[] bs) throws SecurePreferencesException {
        try {
                return cipher.doFinal(bs);
        }
        catch (Exception e) {
                throw new SecurePreferencesException(e);
        }
    }

