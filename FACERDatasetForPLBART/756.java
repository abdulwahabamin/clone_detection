    /**
     * 将字节数组转�?�为�??六进制字符数组
     *
     * @param data
     *            byte[]
     * @param toLowerCase
     *            <code>true</code> 传�?��?�?写格�? ， <code>false</code> 传�?��?大写格�?
     * @return �??六进制char[]
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

