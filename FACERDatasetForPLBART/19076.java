    /**
     * Encodes a byte array into Base64 notation.
     *
     * @param source the data to convert
     * @param off offset in array where conversion should begin
     * @param len length of data to convert
     * @param alphabet is the encoding alphabet
     * @param maxLineLength maximum length of one line.
     * @return the BASE64-encoded byte array
     */
    public static byte[] encode(byte[] source, int off, int len, byte[] alphabet,
            int maxLineLength) {
        int lenDiv3 = (len + 2) / 3; // ceil(len / 3)
        int len43 = lenDiv3 * 4;
        byte[] outBuff = new byte[len43 // Main 4:3
                                  + (len43 / maxLineLength)]; // New lines

        int d = 0;
        int e = 0;
        int len2 = len - 2;
        int lineLength = 0;
        for (; d < len2; d += 3, e += 4) {

            // The following block of code is the same as
            // encode3to4( source, d + off, 3, outBuff, e, alphabet );
            // but inlined for faster encoding (~20% improvement)
            int inBuff =
                    ((source[d + off] << 24) >>> 8)
                    | ((source[d + 1 + off] << 24) >>> 16)
                    | ((source[d + 2 + off] << 24) >>> 24);
            outBuff[e] = alphabet[(inBuff >>> 18)];
            outBuff[e + 1] = alphabet[(inBuff >>> 12) & 0x3f];
            outBuff[e + 2] = alphabet[(inBuff >>> 6) & 0x3f];
            outBuff[e + 3] = alphabet[(inBuff) & 0x3f];

            lineLength += 4;
            if (lineLength == maxLineLength) {
                outBuff[e + 4] = NEW_LINE;
                e++;
                lineLength = 0;
            } // end if: end of line
        } // end for: each piece of array

        if (d < len) {
            encode3to4(source, d + off, len - d, outBuff, e, alphabet);

            lineLength += 4;
            if (lineLength == maxLineLength) {
                // Add a last newline
                outBuff[e + 4] = NEW_LINE;
                e++;
            }
            e += 4;
        }

        assert (e == outBuff.length);
        return outBuff;
    }

