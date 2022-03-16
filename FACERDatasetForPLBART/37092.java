    /**
     * ä¿?å­˜ Stringæ•°æ?® åˆ° ç¼“å­˜ä¸­
     *
     * @param key   ä¿?å­˜çš„key
     * @param value ä¿?å­˜çš„Stringæ•°æ?®
     */
    public void put(String key, String value) {
        File file = mCache.newFile(key);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file), 1024);
            out.write(value);
        } catch (IOException e) {
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

