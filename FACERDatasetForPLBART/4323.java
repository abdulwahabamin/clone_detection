    public static byte[] encodeForEncriptionRawBtye(byte[] encodeBytes) {
        byte[] encoded=null;
        try {
            encoded=Base64.encodeToByte(encodeBytes, true);
        } catch(Exception e) {
            //BLog.e("ENC64","Error Dencodeing: "+e.getMessage());
        }
        return encoded;
    }

