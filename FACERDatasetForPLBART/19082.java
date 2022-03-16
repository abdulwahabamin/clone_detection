    /**
     * Decodes Base64 content in byte array format and returns
     * the decoded byte array.
     *
     * @param source the Base64 encoded data
     * @param off    the offset of where to begin decoding
     * @param len    the length of characters to decode
     * @return decoded data
     * @since 1.3
     * @throws Base64DecoderException
     */
    public static byte[] decode(byte[] source, int off, int len)
            throws Base64DecoderException {
        return decode(source, off, len, DECODABET);
    }

