    /**
     * è¯»å?– bitmap æ•°æ?®
     *
     * @param key
     * @return bitmap æ•°æ?®
     */
    public Bitmap getAsBitmap(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(key));
    }

