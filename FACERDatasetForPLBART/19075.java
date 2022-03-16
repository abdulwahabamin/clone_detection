    /**
     * Encodes a byte array into Base64 notation.
     *
     * @param source the data to convert
     * @param off offset in array where conversion should begin
     * @param len length of data to convert
     * @param alphabet the encoding alphabet
     * @param doPadding is {@code true} to pad result with '=' chars
     * if it does not fall on 3 byte boundaries
     * @since 1.4
     */
    public static String encode(byte[] source, int off, int len, byte[] alphabet,
            boolean doPadding) {
        byte[] outBuff = encode(source, off, len, alphabet, Integer.MAX_VALUE);
        int outLen = outBuff.length;

        // If doPadding is false, set length to truncate '='
        // padding characters
        while (doPadding == false && outLen > 0) {
            if (outBuff[outLen - 1] != '=') {
                break;
            }
            outLen -= 1;
        }

        return new String(outBuff, 0, outLen);
    }

