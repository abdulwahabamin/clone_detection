    public static String encodeForEncriptionRaw(byte[] encodeBytes) {
        String encoded=null;
        try {
            encoded=Base64.encodeToString(encodeBytes, true);
        } catch(Exception e) {
            //BLog.e("ENC64","Error Dencodeing: "+e.getMessage());
        }
        return encoded;
    }

