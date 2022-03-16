    /**
     * ä¿?å­˜List<Integer>
     *
     * @param key
     * @param values
     */
    public static boolean putIntList(Context context, String key, List<Integer> values) {
        SharedPreferences.Editor edit = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        edit.putInt(key, values.size());
        for (int i = 0; i < values.size(); i++) {
            edit.putInt(key + i, values.get(i));
        }
        return edit.commit();
    }

