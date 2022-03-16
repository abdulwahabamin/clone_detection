    /**
     * 将�??六进制字符数组转�?�为字节数组
     *
     * @param data
     *            �??六进制char[]
     * @return byte[]
     * @throws RuntimeException
     *             如果�?�??六进制字符数组是一个奇怪的长度，将抛出�?行时异常
     */
    public static byte[] decodeHex(char[] data) {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

