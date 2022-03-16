    /**
     * 将�?务器返回的所有天气信�?�存储到SharedPreferences文件中
     *
     * @param context
     * @param city
     * @param wendu
     * @param high_00
     * @param low_00
     * @param date_00
     * @param type_00
     * @param fengli_00
     * @param high_0
     * @param low_0
     * @param date_0
     * @param type_0
     * @param fengli_0
     * @param high_1
     * @param low_1
     * @param date_1
     * @param type_1
     * @param fengli_1
     * @param high_2
     * @param low_2
     * @param date_2
     * @param type_2
     * @param fengli_2
     * @param high_3
     * @param low_3
     * @param date_3
     * @param type_3
     * @param fengli_3
     * @param high_4
     * @param low_4
     * @param date_4
     * @param type_4
     * @param fengli_4
     */
    private static void saveWeather(Context context, String city, String wendu, String high_00, String low_00, String date_00, String type_00, String fengli_00, String high_0, String low_0, String date_0, String type_0, String fengli_0, String high_1, String low_1, String date_1, String type_1, String fengli_1, String high_2, String low_2, String date_2, String type_2, String fengli_2, String high_3, String low_3, String date_3, String type_3, String fengli_3, String high_4, String low_4, String date_4, String type_4, String fengli_4) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm刷新", Locale.CHINA);
        SharedPreferences.Editor editor = context.getSharedPreferences(city, 0).edit();
        editor.putBoolean("city_selected", true);
        editor.putString("current_date", sdf.format(new Date()));
        editor.putString("city", city);
        editor.putString("wendu", wendu);

        editor.putString("high_00", high_00);
        editor.putString("low_00", low_00);
        editor.putString("date_00", date_00);
        editor.putString("type_00", type_00);
        //得到的“昨日风力�?如果是微风，就总是少一个“级�?字——强迫症优化
        if (fengli_00.equals("微风")) {
            fengli_00 = "微风级";
        }
        editor.putString("fengli_00", fengli_00);

        editor.putString("high_0", high_0);
        editor.putString("low_0", low_0);
        editor.putString("date_0", date_0);
        editor.putString("type_0", type_0);
        editor.putString("fengli_0", fengli_0);

        editor.putString("high_1", high_1);
        editor.putString("low_1", low_1);
        editor.putString("date_1", date_1);
        editor.putString("type_1", type_1);
        editor.putString("fengli_1", fengli_1);

        editor.putString("high_2", high_2);
        editor.putString("low_2", low_2);
        editor.putString("date_2", date_2);
        editor.putString("type_2", type_2);
        editor.putString("fengli_2", fengli_2);

        editor.putString("high_3", high_3);
        editor.putString("low_3", low_3);
        editor.putString("date_3", date_3);
        editor.putString("type_3", type_3);
        editor.putString("fengli_3", fengli_3);

        editor.putString("high_4", high_4);
        editor.putString("low_4", low_4);
        editor.putString("date_4", date_4);
        editor.putString("type_4", type_4);
        editor.putString("fengli_4", fengli_4);

        editor.commit();
    }

