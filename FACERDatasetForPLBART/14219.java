    /**
     * @param context
     * @param name
     * @param def
     * @return number of weeks used to create the Recent tab
     */
    public static int getIntPref(Context context, String name, int def) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        return prefs.getInt(name, def);
    }

