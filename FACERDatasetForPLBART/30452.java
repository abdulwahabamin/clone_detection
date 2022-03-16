    /**
     * ä¿?å­˜List<String>
     *
     * @param key
     * @param values
     */
    public static boolean putStringList(Context context, String key, List<String> values) {
        SharedPreferences.Editor edit = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        edit.putInt(key, values.size());
        for (int i = 0; i < values.size(); i++) {
            edit.putString(key + i, values.get(i));
        }
        return edit.commit();
    }

