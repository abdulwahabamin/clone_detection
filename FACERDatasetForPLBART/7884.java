    public static String decrypt( String seed, String encrypted ) throws Exception {
        byte[] rawKey = getRawKey( seed.getBytes() );
        byte[] enc = Utils.hexStringToBytes( encrypted );
        byte[] result = decrypt( rawKey, enc );
        return new String( result );
    }

