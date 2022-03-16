    /**
     * 从SharedPreferences文件中读�?�存储的天气信�?�，并显示到界�?�上
     *
     * @author �?�?宇 2016-7-29 下�?�2:32:21
     */
    private void showWeather(String cityName) {
        if (cityName == null) {
            city_name_tv.setText("一个城市也没有");
            nonce_city_name.setText("N/A");
            current_date_tv.setText(null);
            wendu_tv.setText("N/A");

            high_00_tv.setText(null);
            low_00_tv.setText(null);
            date_00_tv.setText(null);
            type_00_tv.setText(null);
            fengli_00_tv.setText(null);
            ic_00_iv.setImageResource(R.mipmap.back);
            divide_00.setText(null);

            high_0_tv.setText(null);
            low_0_tv.setText(null);
            date_0_tv.setText(null);
            type_0_tv.setText(null);
            fengli_0_tv.setText(null);
            ic_0_iv.setImageResource(R.mipmap.back);
            du_0.setText(null);
            divide_0.setText(null);
            type_000_tv.setText(null);
            high_000_tv.setText(null);
            low_000_tv.setText(null);
            divide_000.setText(null);
            ic_000_iv.setImageResource(R.mipmap.ic_launcher);

            high_1_tv.setText(null);
            low_1_tv.setText(null);
            date_1_tv.setText(null);
            type_1_tv.setText(null);
            fengli_1_tv.setText(null);
            ic_1_iv.setImageResource(R.mipmap.back);
            divide_1.setText(null);

            high_2_tv.setText(null);
            low_2_tv.setText(null);
            date_2_tv.setText(null);
            type_2_tv.setText(null);
            fengli_2_tv.setText(null);
            ic_2_iv.setImageResource(R.mipmap.back);
            divide_2.setText(null);

            high_3_tv.setText(null);
            low_3_tv.setText(null);
            date_3_tv.setText(null);
            type_3_tv.setText(null);
            fengli_3_tv.setText(null);
            ic_3_iv.setImageResource(R.mipmap.back);
            divide_3.setText(null);

            high_4_tv.setText(null);
            low_4_tv.setText(null);
            date_4_tv.setText(null);
            type_4_tv.setText(null);
            fengli_4_tv.setText(null);
            ic_4_iv.setImageResource(R.mipmap.back);
            divide_4.setText(null);

        } else {
            // 存储当�?城市�??
            SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
            editor.putString("nonce_city", cityName);
            editor.commit();

            SharedPreferences prefs = getSharedPreferences(cityName, MODE_PRIVATE);
            city_name_tv.setText(prefs.getString("city", null));
            nonce_city_name.setText(prefs.getString("city", null));
            current_date_tv.setText(prefs.getString("current_date", null));
            wendu_tv.setText(prefs.getString("wendu", null));

            high_00_tv.setText(prefs.getString("high_00", null));
            low_00_tv.setText(prefs.getString("low_00", null));
            date_00_tv.setText(prefs.getString("date_00", null));
            type_00_tv.setText(prefs.getString("type_00", null));
            fengli_00_tv.setText(prefs.getString("fengli_00", null));
            ic_00_iv.setImageResource(selectImage(prefs.getString("type_00", null)));
            divide_00.setText("/");

            high_0_tv.setText(prefs.getString("high_0", null));
            low_0_tv.setText(prefs.getString("low_0", null));
            date_0_tv.setText(prefs.getString("date_0", null));
            type_0_tv.setText(prefs.getString("type_0", null));
            fengli_0_tv.setText(prefs.getString("fengli_0", null));
            ic_0_iv.setImageResource(selectImage(prefs.getString("type_0", null)));
            du_0.setText("°");
            divide_0.setText("/");
            type_000_tv.setText(prefs.getString("type_0", null));
            high_000_tv.setText(prefs.getString("high_0", null));
            low_000_tv.setText(prefs.getString("low_0", null));
            divide_000.setText("/");
            ic_000_iv.setImageResource(selectImage(prefs.getString("type_0", null)));

            high_1_tv.setText(prefs.getString("high_1", null));
            low_1_tv.setText(prefs.getString("low_1", null));
            date_1_tv.setText(prefs.getString("date_1", null));
            type_1_tv.setText(prefs.getString("type_1", null));
            fengli_1_tv.setText(prefs.getString("fengli_1", null));
            ic_1_iv.setImageResource(selectImage(prefs.getString("type_1", null)));
            divide_1.setText("/");

            high_2_tv.setText(prefs.getString("high_2", null));
            low_2_tv.setText(prefs.getString("low_2", null));
            date_2_tv.setText(prefs.getString("date_2", null));
            type_2_tv.setText(prefs.getString("type_2", null));
            fengli_2_tv.setText(prefs.getString("fengli_2", null));
            ic_2_iv.setImageResource(selectImage(prefs.getString("type_2", null)));
            divide_2.setText("/");

            high_3_tv.setText(prefs.getString("high_3", null));
            low_3_tv.setText(prefs.getString("low_3", null));
            date_3_tv.setText(prefs.getString("date_3", null));
            type_3_tv.setText(prefs.getString("type_3", null));
            fengli_3_tv.setText(prefs.getString("fengli_3", null));
            ic_3_iv.setImageResource(selectImage(prefs.getString("type_3", null)));
            divide_3.setText("/");

            high_4_tv.setText(prefs.getString("high_4", null));
            low_4_tv.setText(prefs.getString("low_4", null));
            date_4_tv.setText(prefs.getString("date_4", null));
            type_4_tv.setText(prefs.getString("type_4", null));
            fengli_4_tv.setText(prefs.getString("fengli_4", null));
            ic_4_iv.setImageResource(selectImage(prefs.getString("type_4", null)));
            divide_4.setText("/");
        }
    }

