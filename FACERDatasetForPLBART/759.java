    /**
     * 将字节数组转�?�为�??六进制字符串
     *
     * @param data
     *            byte[]
     * @param toLowerCase
     *            <code>true</code> 传�?��?�?写格�? ， <code>false</code> 传�?��?大写格�?
     * @return �??六进制String
     */
    public static String encodeHexStr(byte[] data, boolean toLowerCase) {
        return encodeHexStr(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

