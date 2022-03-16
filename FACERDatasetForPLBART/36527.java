    private void findView() {

        instance = this;

        swipe_container = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipe_container.setOnRefreshListener(this);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_list = findViewById(R.id.menu_list);
        city_list = (ListView) findViewById(R.id.city_list);

        //é¦–é¡µå¤©æ°”ä¿¡æ?¯è§†å›¾é¡µé?¢æ·»åŠ å·¦å?³æ»‘åŠ¨ç›‘å?¬ï¼Œä»¥å®žçŽ°åˆ‡æ?¢åŸŽå¸‚
        weather_info = (LinearLayout) findViewById(R.id.weather_info);
        weather_info.setOnTouchListener(new View.OnTouchListener() {

            float x1 = 0;
            float x2 = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        ArrayList<String> temp = new ArrayList<String>(10);
                        temp.addAll(cityName_weatherCode.keySet());
                        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
                        int nonceCityIndex = temp.indexOf(prefs.getString("nonce_city", null));
                        if (x1 - x2 > 50 && temp.size() > 1) {
                            if (nonceCityIndex + 1 < temp.size()) {
                                showWeather(temp.get(nonceCityIndex + 1));
                            } else {
                                ToastUtil.showToast(WeatherActivity.this, "å?Žé?¢å·²ç»?æ²¡æœ‰äº† â˜œ", Toast.LENGTH_SHORT);
                            }
                        } else if (x2 - x1 > 50 && temp.size() > 1) {
                            if (nonceCityIndex - 1 >= 0) {
                                showWeather(temp.get(nonceCityIndex - 1));
                            } else {
                                ToastUtil.showToast(WeatherActivity.this, "â˜ž å‰?é?¢å·²ç»?æ²¡æœ‰äº†", Toast.LENGTH_SHORT);
                            }
                        }
                        break;
                }
                return true;
            }
        });

        share_weather = (Button) findViewById(R.id.share_weather);
        share_weather.setOnClickListener(this);
        menu_left = (Button) findViewById(R.id.menu_left);
        menu_left.setOnClickListener(this);
        add_city = (Button) findViewById(R.id.add_city);
        add_city.setOnClickListener(this);
        choose_theme = (Button) findViewById(R.id.choose_theme);
        choose_theme.setOnClickListener(this);
        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(this);
        about = (Button) findViewById(R.id.about);
        about.setOnClickListener(this);

        city_name_tv = (TextView) findViewById(R.id.city_name);
        nonce_city_name = (TextView) findViewById(R.id.nonce_city_name);
        current_date_tv = (TextView) findViewById(R.id.current_date);
        wendu_tv = (TextView) findViewById(R.id.wendu);

        ic_00_iv = (ImageView) findViewById(R.id.ic_00);
        ic_0_iv = (ImageView) findViewById(R.id.ic_0);
        ic_1_iv = (ImageView) findViewById(R.id.ic_1);
        ic_2_iv = (ImageView) findViewById(R.id.ic_2);
        ic_3_iv = (ImageView) findViewById(R.id.ic_3);
        ic_4_iv = (ImageView) findViewById(R.id.ic_4);
        ic_000_iv = (ImageView) findViewById(R.id.ic_000);

        high_00_tv = (TextView) findViewById(R.id.high_00);
        low_00_tv = (TextView) findViewById(R.id.low_00);
        date_00_tv = (TextView) findViewById(R.id.date_00);
        type_00_tv = (TextView) findViewById(R.id.type_00);
        fengli_00_tv = (TextView) findViewById(R.id.fengli_00);
        divide_00 = (TextView) findViewById(R.id.divide_00);

        high_0_tv = (TextView) findViewById(R.id.high_0);
        low_0_tv = (TextView) findViewById(R.id.low_0);
        date_0_tv = (TextView) findViewById(R.id.date_0);
        type_0_tv = (TextView) findViewById(R.id.type_0);
        fengli_0_tv = (TextView) findViewById(R.id.fengli_0);
        du_0 = (TextView) findViewById(R.id.du_0);
        divide_0 = (TextView) findViewById(R.id.divide_0);
        type_000_tv = (TextView) findViewById(R.id.type_000);
        high_000_tv = (TextView) findViewById(R.id.high_000);
        low_000_tv = (TextView) findViewById(R.id.low_000);
        divide_000 = (TextView) findViewById(R.id.divide_000);

        high_1_tv = (TextView) findViewById(R.id.high_1);
        low_1_tv = (TextView) findViewById(R.id.low_1);
        date_1_tv = (TextView) findViewById(R.id.date_1);
        type_1_tv = (TextView) findViewById(R.id.type_1);
        fengli_1_tv = (TextView) findViewById(R.id.fengli_1);
        divide_1 = (TextView) findViewById(R.id.divide_1);

        high_2_tv = (TextView) findViewById(R.id.high_2);
        low_2_tv = (TextView) findViewById(R.id.low_2);
        date_2_tv = (TextView) findViewById(R.id.date_2);
        type_2_tv = (TextView) findViewById(R.id.type_2);
        fengli_2_tv = (TextView) findViewById(R.id.fengli_2);
        divide_2 = (TextView) findViewById(R.id.divide_2);

        high_3_tv = (TextView) findViewById(R.id.high_3);
        low_3_tv = (TextView) findViewById(R.id.low_3);
        date_3_tv = (TextView) findViewById(R.id.date_3);
        type_3_tv = (TextView) findViewById(R.id.type_3);
        fengli_3_tv = (TextView) findViewById(R.id.fengli_3);
        divide_3 = (TextView) findViewById(R.id.divide_3);

        high_4_tv = (TextView) findViewById(R.id.high_4);
        low_4_tv = (TextView) findViewById(R.id.low_4);
        date_4_tv = (TextView) findViewById(R.id.date_4);
        type_4_tv = (TextView) findViewById(R.id.type_4);
        fengli_4_tv = (TextView) findViewById(R.id.fengli_4);
        divide_4 = (TextView) findViewById(R.id.divide_4);
    }

