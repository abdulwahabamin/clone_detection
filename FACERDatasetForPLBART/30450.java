    public static boolean putHashMap(Context context, String key,
                                     HashMap<String, Integer> hashmap) {
        SharedPreferences settings = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        try {
            String listStr = SceneList2String(hashmap);
            editor.putString(key, listStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editor.commit();
    }

