    /**
     * 读�?� Drawable 数�?�
     *
     * @param key
     * @return Drawable 数�?�
     */
    public Drawable getAsDrawable(String key) {
        if (getAsBinary(key) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(key)));
    }

