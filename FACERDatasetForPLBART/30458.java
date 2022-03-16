    /**
     * �?存List<Object>
     *
     * @param context
     * @param key
     * @param datalist
     */
    public <T> void putListBean(Context context, String key, List<T> datalist) {
        SharedPreferences.Editor edit = context.getSharedPreferences(
                PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        if (null == datalist || datalist.size() <= 0) {
            return;
        }
        Gson gson = new Gson();
        //转�?��?json数�?�，�?�?存
        String strJson = gson.toJson(datalist);
        edit.putString(key, strJson);
        edit.commit();
    }

