    /**
     * 解�?�?务器返回的天气JSON数�?�， 并将解�?出的数�?�存储到本地
     *
     * @param context
     * @param response
     * @return
     */
    public static String handleWeatherResponse(Context context, String response) {
        String city = null;
        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONObject data = jsonObject.getJSONObject("data");
            city = data.getString("city");
            String wendu = data.getString("wendu");

            // 昨天（yesterday）
            JSONObject yesterday = data.getJSONObject("yesterday");
            String high_00 = yesterday.getString("high");
            int high_00_length = high_00.length();
            high_00 = high_00.substring(3, high_00_length - 1) + "°";
            String low_00 = yesterday.getString("low");
            int low_00_length = low_00.length();
            low_00 = low_00.substring(3, low_00_length - 1) + "°";
            String date_00 = "昨天";
            String type_00 = yesterday.getString("type");
            String fengli_00 = yesterday.getString("fl");

            JSONArray forecast = data.getJSONArray("forecast");
            // 今天（day_0）
            JSONObject day_0 = forecast.getJSONObject(0);
            String high_0 = day_0.getString("high");
            int high_0_length = high_0.length();
            high_0 = high_0.substring(3, high_0_length - 1) + "°";
            String low_0 = day_0.getString("low");
            int low_0_length = low_0.length();
            low_0 = low_0.substring(3, low_0_length - 1) + "°";
            String date_0 = "今天";
            String type_0 = day_0.getString("type");
            String fengli_0 = day_0.getString("fengli");

            // 明天（day_1）
            JSONObject day_1 = forecast.getJSONObject(1);
            String high_1 = day_1.getString("high");
            int high_1_length = high_1.length();
            high_1 = high_1.substring(3, high_1_length - 1) + "°";
            String low_1 = day_1.getString("low");
            int low_1_length = low_1.length();
            low_1 = low_1.substring(3, low_1_length - 1) + "°";
            String date_1 = "明天";
            String type_1 = day_1.getString("type");
            String fengli_1 = day_1.getString("fengli");

            // �?�天（day_2）
            JSONObject day_2 = forecast.getJSONObject(2);
            String high_2 = day_2.getString("high");
            int high_2_length = high_2.length();
            high_2 = high_2.substring(3, high_2_length - 1) + "°";
            String low_2 = day_2.getString("low");
            int low_2_length = low_2.length();
            low_2 = low_2.substring(3, low_2_length - 1) + "°";
            String date_2 = day_2.getString("date").substring(day_2.getString("date").length() - 3);
            String type_2 = day_2.getString("type");
            String fengli_2 = day_2.getString("fengli");

            // 大�?�天（day_3）
            JSONObject day_3 = forecast.getJSONObject(3);
            String high_3 = day_3.getString("high");
            int high_3_length = high_3.length();
            high_3 = high_3.substring(3, high_3_length - 1) + "°";
            String low_3 = day_3.getString("low");
            int low_3_length = low_3.length();
            low_3 = low_3.substring(3, low_3_length - 1) + "°";
            String date_3 = day_3.getString("date").substring(day_3.getString("date").length() - 3);
            String type_3 = day_3.getString("type");
            String fengli_3 = day_3.getString("fengli");

            // 大大�?�天（day_4）
            JSONObject day_4 = forecast.getJSONObject(4);
            String high_4 = day_4.getString("high");
            int high_4_length = high_4.length();
            high_4 = high_4.substring(3, high_4_length - 1) + "°";
            String low_4 = day_4.getString("low");
            int low_4_length = low_4.length();
            low_4 = low_4.substring(3, low_4_length - 1) + "°";
            String date_4 = day_4.getString("date").substring(day_4.getString("date").length() - 3);
            String type_4 = day_4.getString("type");
            String fengli_4 = day_4.getString("fengli");

            // 处�?�json数�?�中“风力�?字段<![CDATA[]]>问题（问题样例：<![CDATA[<3级]]>）
            // 待�?务器返回数�?�良好时，这里的�?作�?�以删除
            fengli_00 = fengli_00.substring(9, fengli_00.length() - 3);
            fengli_0 = fengli_0.substring(9, fengli_0.length() - 3);
            fengli_1 = fengli_1.substring(9, fengli_1.length() - 3);
            fengli_2 = fengli_2.substring(9, fengli_2.length() - 3);
            fengli_3 = fengli_3.substring(9, fengli_3.length() - 3);
            fengli_4 = fengli_4.substring(9, fengli_4.length() - 3);

            //将�?务器返回的所有天气信�?�存储到SharedPreferences文件中
            saveWeather(context, city, wendu, high_00, low_00, date_00, type_00, fengli_00, high_0, low_0, date_0, type_0, fengli_0, high_1, low_1, date_1, type_1, fengli_1, high_2, low_2, date_2, type_2, fengli_2, high_3, low_3, date_3, type_3, fengli_3, high_4, low_4, date_4, type_4, fengli_4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return city;
    }

