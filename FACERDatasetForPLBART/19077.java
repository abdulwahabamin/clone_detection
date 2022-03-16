    /**
     * Decodes four bytes from array <var>source</var>
     * and writes the resulting bytes (up to three of them)
     * to <var>destination</var>.
     * The source and destination arrays can be manipulated
     * anywhere along their length by specifying
     * <var>srcOffset</var> and <var>destOffset</var>.
     * This method does not check to make sure your arrays
     * are large enough to accommodate <var>srcOffset</var> + 4 for
     * the <var>source</var> array or <var>destOffset</var> + 3 for
     * the <var>destination</var> array.
     * This method returns the actual number of bytes that
     * were converted from the Base64 encoding.
     *
     *
     * @param source the array to convert
     * @param srcOffset the index where conversion begins
     * @param destination the array to hold the conversion
     * @param destOffset the index where output will be put
     * @param decodabet the decodabet for decoding Base64 content
     * @return the number of decoded bytes converted
     * @since 1.3
     */
    private static int decode4to3(byte[] source, int srcOffset,
            byte[] destination, int destOffset, byte[] decodabet) {
        // Example: Dk==
        if (source[srcOffset + 2] == EQUALS_SIGN) {
            int outBuff =
                    ((decodabet[source[srcOffset]] << 24) >>> 6)
                    | ((decodabet[source[srcOffset + 1]] << 24) >>> 12);

            destination[destOffset] = (byte) (outBuff >>> 16);
            return 1;
        } else if (source[srcOffset + 3] == EQUALS_SIGN) {
            // Example: DkL=
            int outBuff =
                    ((decodabet[source[srcOffset]] << 24) >>> 6)
                    | ((decodabet[source[srcOffset + 1]] << 24) >>> 12)
                    | ((decodabet[source[srcOffset + 2]] << 24) >>> 18);

            destination[destOffset] = (byte) (outBuff >>> 16);
            destination[destOffset + 1] = (byte) (outBuff >>> 8);
            return 2;
        } else {
            // Example: DkLE
            int outBuff =
                    ((decodabet[source[srcOffset]] << 24) >>> 6)
                    | ((decodabet[source[srcOffset + 1]] << 24) >>> 12)
                    | ((decodabet[source[srcOffset + 2]] << 24) >>> 18)
                    | ((decodabet[source[srcOffset + 3]] << 24) >>> 24);

            destination[destOffset] = (byte) (outBuff >> 16);
            destination[destOffset + 1] = (byte) (outBuff >> 8);
            destination[destOffset + 2] = (byte) (outBuff);
            return 3;
        }
    } // end decodeToBytes

