    /**
     * @param context
     * @param key
     * @param clazz   这里传入一个类就是我们所需�?的实体类(obj)
     * @return 返回我们�?装好的该实体类(obj)
     */
    public static <T> T getBean(Context context, String key,
                                Class<T> clazz) {
        String objString = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getString(key, "");
        Gson gson = new Gson();
        return gson.fromJson(objString, clazz);
    }

