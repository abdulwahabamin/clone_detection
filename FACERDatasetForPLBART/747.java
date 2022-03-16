    /**
     * int数值转�?�为byte数组，低�?在�?
     * @param value
     * @param n
     * @return
     */
    public static byte[] intToBytesLow(int value, int n){
        byte[] src = new byte[n];
        for(int i = 0; i < n; i++){
            src[i] = (byte) ((value >> (8 * i)) & 0xFF);
        }
        return src;
    }

