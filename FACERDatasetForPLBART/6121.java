    /**
     * è¯»å?– Drawable æ•°æ?®
     *
     * @param key
     * @return Drawable æ•°æ?®
     */
    public Drawable getAsDrawable(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(key)));
    }

