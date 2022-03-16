    /**
     * int数值转�?�为byte数组，高�?在�?
     * @param value
     * @param n
     * @return
     */
    public static byte[] intToBytesHigh(int value, int n){
        byte[] src = new byte[n];
        for(int i = 0; i < n; i++){
            src[i] = (byte) ((value >> (8 * (n - i - 1))) & 0xFF);
        }
        return src;
    }

