    /**
     * 读�?� bitmap 数�?�
     *
     * @param key
     * @return bitmap 数�?�
     */
    public Bitmap getAsBitmap(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(key));
    }

