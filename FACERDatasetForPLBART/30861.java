    public static void putBooleanToPreferences(Context context, String prfName, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(prfName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

