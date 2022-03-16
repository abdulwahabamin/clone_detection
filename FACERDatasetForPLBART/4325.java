    public static byte[] decodeFromEncriptionRaw(String stringToDecode) {
        try {
            return Base64.decode(stringToDecode.toCharArray());
        } catch(Exception e) {
            //BLog.e("ENC64","Error Dencodeing: "+e.getMessage());
        }
        return null;
    }

