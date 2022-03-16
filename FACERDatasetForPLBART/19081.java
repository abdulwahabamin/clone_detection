    /**
     * Decodes web safe Base64 content in byte array format and returns
     * the decoded data.
     * Web safe encoding uses '-' instead of '+', '_' instead of '/'
     *
     * @param source the string to decode (decoded in default encoding)
     * @return the decoded data
     */
    public static byte[] decodeWebSafe(byte[] source)
            throws Base64DecoderException {
        return decodeWebSafe(source, 0, source.length);
    }

