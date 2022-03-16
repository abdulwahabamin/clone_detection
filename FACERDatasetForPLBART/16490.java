    /**
     * 写入对象
     *
     * @param key    key
     * @param object object
     */
    public boolean putObject(String key, Object object) {
        if (object == null) {
            SharedPreferences.Editor editor = sp.edit().remove(key);
            return editor.commit();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        String objectStr = new String(Base64.encode(baos.toByteArray(),
                Base64.DEFAULT));
        try {
            baos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, objectStr);
        return editor.commit();
    }

