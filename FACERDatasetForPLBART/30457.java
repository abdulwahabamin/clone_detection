    /**
     * èŽ·å?–List<Long>
     *
     * @param key
     * @return
     */
    public static List<Long> getLongList(Context context, String key) {
        List<Long> values = new ArrayList<>();
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        int listSize = sp.getInt(key, 0);
        for (int i = 0; i < listSize; i++) {
            values.add(sp.getLong(key + i, 0));
        }
        return values;
    }

