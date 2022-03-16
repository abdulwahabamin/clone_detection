    /**
     * Decodes Base64 content using the supplied decodabet and returns
     * the decoded byte array.
     *
     * @param source the Base64 encoded data
     * @param off the offset of where to begin decoding
     * @param len the length of characters to decode
     * @param decodabet the decodabet for decoding Base64 content
     * @return decoded data
     */
    public static byte[] decode(byte[] source, int off, int len, byte[] decodabet)
            throws Base64DecoderException {
        int len34 = len * 3 / 4;
        byte[] outBuff = new byte[2 + len34]; // Upper limit on size of output
        int outBuffPosn = 0;

        byte[] b4 = new byte[4];
        int b4Posn = 0;
        int i = 0;
        byte sbiCrop = 0;
        byte sbiDecode = 0;
        for (i = 0; i < len; i++) {
            sbiCrop = (byte) (source[i + off] & 0x7f); // Only the low seven bits
            sbiDecode = decodabet[sbiCrop];

            if (sbiDecode >= WHITE_SPACE_ENC) { // White space Equals sign or better
                if (sbiDecode >= EQUALS_SIGN_ENC) {
                    // An equals sign (for padding) must not occur at position 0 or 1
                    // and must be the last byte[s] in the encoded value
                    if (sbiCrop == EQUALS_SIGN) {
                        int bytesLeft = len - i;
                        byte lastByte = (byte) (source[len - 1 + off] & 0x7f);
                        if (b4Posn == 0 || b4Posn == 1) {
                            throw new Base64DecoderException(
                                    "invalid padding byte '=' at byte offset " + i);
                        } else if ((b4Posn == 3 && bytesLeft > 2)
                                || (b4Posn == 4 && bytesLeft > 1)) {
                            throw new Base64DecoderException(
                                    "padding byte '=' falsely signals end of encoded value "
                                            + "at offset " + i);
                        } else if (lastByte != EQUALS_SIGN && lastByte != NEW_LINE) {
                            throw new Base64DecoderException(
                                    "encoded value has invalid trailing byte");
                        }
                        break;
                    }

                    b4[b4Posn++] = sbiCrop;
                    if (b4Posn == 4) {
                        outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn, decodabet);
                        b4Posn = 0;
                    }
                }
            } else {
                throw new Base64DecoderException("Bad Base64 input character at " + i
                        + ": " + source[i + off] + "(decimal)");
            }
        }

        // Because web safe encoding allows non padding base64 encodes, we
        // need to pad the rest of the b4 buffer with equal signs when
        // b4Posn != 0.  There can be at most 2 equal signs at the end of
        // four characters, so the b4 buffer must have two or three
        // characters.  This also catches the case where the input is
        // padded with EQUALS_SIGN
        if (b4Posn != 0) {
            if (b4Posn == 1) {
                throw new Base64DecoderException("single trailing character at offset "
                        + (len - 1));
            }
            b4[b4Posn++] = EQUALS_SIGN;
            outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn, decodabet);
        }

        byte[] out = new byte[outBuffPosn];
        System.arraycopy(outBuff, 0, out, 0, outBuffPosn);
        return out;
    }

