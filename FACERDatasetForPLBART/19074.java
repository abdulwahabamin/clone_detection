    /**
     * Encodes a byte array into web safe Base64 notation.
     *
     * @param source The data to convert
     * @param doPadding is {@code true} to pad result with '=' chars
     *        if it does not fall on 3 byte boundaries
     */
    public static String encodeWebSafe(byte[] source, boolean doPadding) {
        return encode(source, 0, source.length, WEBSAFE_ALPHABET, doPadding);
    }

