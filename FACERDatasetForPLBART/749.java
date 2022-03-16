    /**
     * byteæ•°ç»„è½¬æ?¢ä¸ºintï¼Œä½Žä½?åœ¨å‰?
     * @param bytes
     * @param offset
     * @return
     */
    public static int bytesToIntLow(byte[] bytes, int offset){
        int value = 0;
        if(bytes == null || bytes.length == 0){
            return value;
        }
        for(int i = 0; i < bytes.length; i++){
            value += (int) ((bytes[i] & 0xFF) << (8 * i));
        }
        return value;
    }

