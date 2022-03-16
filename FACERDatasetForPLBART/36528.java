    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
        int chooseTheme = prefs.getInt("choose_theme", 1);
        switch (chooseTheme) {
            case 1:
                setTheme(R.style.AppTheme1);
                break;
            case 2:
                setTheme(R.style.AppTheme2);
                break;
            case 3:
                setTheme(R.style.AppTheme3);
                break;
            case 4:
                setTheme(R.style.AppTheme4);
                break;
            case 5:
                setTheme(R.style.AppTheme5);
                break;
            case 6:
                setTheme(R.style.AppTheme6);
                break;
            case 7:
                setTheme(R.style.AppTheme7);
                break;
            case 8:
                setTheme(R.style.AppTheme8);
                break;
            case 9:
                setTheme(R.style.AppTheme9);
                break;
            case 10:
                setTheme(R.style.AppTheme10);
                break;
            case 11:
                setTheme(R.style.AppTheme11);
                break;
            case 12:
                setTheme(R.style.AppTheme12);
                break;
        }
        setContentView(R.layout.weather_layout);

        findView();

        // 更新当�?城市列表
        updateCityList(null, null);

        // 判断是�?�为首次�?�动APP
        boolean isFirstStart = prefs.getBoolean("first_start", true);
        if (isFirstStart) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }

        // �?��?桌�?��?部件�?�动的广播
        Intent intent = new Intent("com.simpleweather.app.MY_WIDGETPROVIDER_BROADCAST");
        sendBroadcast(intent);

        // 根�?�设置记录，判断是�?�需�?�?�动�?��?�更新�?务
        prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
        boolean isBackUpdate = prefs.getBoolean("back_update", true);
        if (isBackUpdate) {
            Intent i = new Intent(this, AutoUpdateService.class);
            i.putExtra("anHour", -1);
            startService(i);
        }

        // 有县级代�?�时就去查询天气
        String countyCode = getIntent().getStringExtra("county_code");
        if (!TextUtils.isEmpty(countyCode)) {
            //如果是�?2次添加城市，就弹出下滑刷新的�??示信�?�
            prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
            int isFirstAddCity = prefs.getInt("first_add_city", 1);
            if (isFirstAddCity == 1) {

                alert = null;
                builder = new AlertDialog.Builder(WeatherActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                alert = builder.setMessage("首页下滑�?�以刷新天气哦 ☟").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create(); // 创建AlertDialog对象
                alert.show(); // 显示对�?框

                SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                editor.putInt("first_add_city", isFirstAddCity + 1);
                editor.commit();
            } else if (isFirstAddCity == 2) {

                alert = null;
                builder = new AlertDialog.Builder(WeatherActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                alert = builder.setMessage("左�?�滑动�?�以快速切�?�城市哦 ☜ ☞").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create(); // 创建AlertDialog对象
                alert.show(); // 显示对�?框

                SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                editor.putInt("first_add_city", isFirstAddCity + 1);
                editor.commit();
            }

            queryWeatherCode(countyCode);
        }

    }

