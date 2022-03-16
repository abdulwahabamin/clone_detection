    /**
     * å°†å­—èŠ‚æ•°ç»„è½¬æ?¢ä¸ºå??å…­è¿›åˆ¶å­—ç¬¦æ•°ç»„
     *
     * @param data
     *            byte[]
     * @param toLowerCase
     *            <code>true</code> ä¼ æ?¢æˆ?å°?å†™æ ¼å¼? ï¼Œ <code>false</code> ä¼ æ?¢æˆ?å¤§å†™æ ¼å¼?
     * @return å??å…­è¿›åˆ¶char[]
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

