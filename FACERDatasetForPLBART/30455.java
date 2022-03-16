    /**
     * èŽ·å?–List<Integer>
     *
     * @param key
     * @return
     */
    public static List<Integer> getIntList(Context context, String key) {
        List<Integer> values = new ArrayList<>();
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        int listSize = sp.getInt(key, 0);
        for (int i = 0; i < listSize; i++) {
            values.add(sp.getInt(key + i, 0));
        }
        return values;
    }

