    /**
     * byte数组转�?�为int，高�?在�?
     * @param bytes
     * @param offset
     * @return
     */
    public static int bytesToIntHigh(byte[] bytes, int offset){
        int value = 0;
        if(bytes == null || bytes.length == 0){
            return value;
        }
        for(int i = 0; i < bytes.length; i++){
            value += (int) ((bytes[i] & 0xFF) << (8 * (bytes.length - i - 1)));
        }
        return value;
    }

