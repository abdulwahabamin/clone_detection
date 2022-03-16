    /**
     * ä¿?å­˜ Serializableæ•°æ?®åˆ° ç¼“å­˜ä¸­
     *
     * @param key      ä¿?å­˜çš„key
     * @param value    ä¿?å­˜çš„value
     * @param saveTime ä¿?å­˜çš„æ—¶é—´ï¼Œå?•ä½?ï¼šç§’
     */
    public void put(String key, Serializable value, int saveTime) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(value);
            byte[] data = baos.toByteArray();
            if (saveTime != -1) {
                put(key, data, saveTime);
            } else {
                put(key, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
            }
        }
    }

