    /**
     * èŽ·å?–List<String>
     *
     * @param key
     * @return
     */
    public static List<String> getStringList(Context context, String key) {
        List<String> values = new ArrayList<>();
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        int listSize = sp.getInt(key, 0);
        for (int i = 0; i < listSize; i++) {
            values.add(sp.getString(key + i, null));
        }
        return values;
    }

