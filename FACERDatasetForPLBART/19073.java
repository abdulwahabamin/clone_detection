    /**
     * Encodes a byte array into Base64 notation.
     * Equivalent to calling
     * {@code encodeBytes(source, 0, source.length)}
     *
     * @param source The data to convert
     * @since 1.4
     */
    public static String encode(byte[] source) {
        return encode(source, 0, source.length, ALPHABET, true);
    }

