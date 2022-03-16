    /**
     * 存放实体类以�?�任�?类型
     *
     * @param context 上下文对象
     * @param key
     * @param obj
     */
    public static void saveBean(Context context, String key,
                                Object obj) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String objString = gson.toJson(obj);
        editor.putString(key, objString).commit();
    }

