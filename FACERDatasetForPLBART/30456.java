    /**
     * ä¿?å­˜List<Long>
     *
     * @param key
     * @param values
     */
    public static boolean putLongList(Context context, String key, List<Long> values) {
        SharedPreferences.Editor edit = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        edit.putInt(key, values.size());
        for (int i = 0; i < values.size(); i++) {
            edit.putLong(key + i, values.get(i));
        }
        return edit.commit();
    }

