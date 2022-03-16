    /**
     * Decodes web safe Base64 content in byte array format and returns
     * the decoded byte array.
     * Web safe encoding uses '-' instead of '+', '_' instead of '/'
     *
     * @param source the Base64 encoded data
     * @param off    the offset of where to begin decoding
     * @param len    the length of characters to decode
     * @return decoded data
     */
    public static byte[] decodeWebSafe(byte[] source, int off, int len)
            throws Base64DecoderException {
        return decode(source, off, len, WEBSAFE_DECODABET);
    }

