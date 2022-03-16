    public static boolean isBinaryData(byte[] data) {
        int lastByteTranslated = 0;
        final int read = Math.min(10 * 1024, data.length);
        final long max = ((5 * read) / 100); // 5% percent of binary bytes
        int hits = 0;
        for (int i = 0; i < read; i++) {
            final byte b = data[i];
            int ub = b & (0xff);  // unsigned
            int utf8value = lastByteTranslated + ub;
            lastByteTranslated = (ub) << 8;

            if (ub == 0x09 /*(tab)*/
                    || ub == 0x0A /*(line feed)*/
                    || ub == 0x0C /*(form feed)*/
                    || ub == 0x0D /*(carriage return)*/
                    || (ub >= 0x20 && ub <= 0x7E) /* Letters, Numbers and other "normal symbols" */
                    || (ub >= 0xA0 && ub <= 0xEE) /* Symbols of Latin-1 */
                    || (utf8value >= 0x2E2E && utf8value <= 0xC3BF)) { /* Latin-1 in UTF-8 encoding */
                // ok
            } else {
                // binary
                hits++;
            }
        }
        return hits > max;
    }

