    /**
     * ä¿?å­˜ byteæ•°æ?® åˆ° ç¼“å­˜ä¸­
     *
     * @param key
     *            ä¿?å­˜çš„key
     * @param value
     *            ä¿?å­˜çš„æ•°æ?®
     */
    public void put(String key, byte[] value) {
        File file = mCache.newFile(key);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mCache.put(file);
        }
    }

