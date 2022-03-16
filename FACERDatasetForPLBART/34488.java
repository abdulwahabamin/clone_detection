    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        infoContainder = findViewById(R.id.info_container);
        weatherBg = findViewById(R.id.weather_bg);

        Intent intent = getIntent();
        WeatherData weatherData = (WeatherData) intent.getExtras().getSerializable("weather");
        Log.d("weather", weatherData.toString());
        weatherBg.setBackground(getDrawable(WeatherData.getColorByCode(Integer.parseInt(weatherData.cond[0]))));
        infoContainder.setBackground(getDrawable(WeatherData.getColorByCode(Integer.parseInt(weatherData.cond[0]))));
        weatherCond = (TextView) findViewById(R.id.weather_cond);
        weatherTmp = (TextView) findViewById(R.id.weather_tmp);
        weatherIcon = (ImageView) findViewById(R.id.weather_icon);
        weatherCond.setText(weatherData.cond[1]);
        weatherTmp.setText(weatherData.fl);
        weatherIcon.setImageDrawable(getDrawable(WeatherData.getWeatherIconDrawableId(Integer.parseInt(weatherData.cond[0]))));
        getSupportActionBar().setTitle(weatherData.city);

        weatherDaily = (LinearLayout) findViewById(R.id.daily_forecast_content);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        Log.d("weather", " week : "  + week);
        int i = 0;
        for (HeWeatherBuilder.DailyForecast dailyForecast : weatherData.dailyForecasts) {
            Hodler hodler;
            View convertView = LayoutInflater.from(CityWeatherActivity.this).inflate(R.layout.daily_forecast_item, null);
            hodler = new Hodler();
            hodler.icon = (ImageView) convertView.findViewById(R.id.item_icon);
            hodler.date = (TextView) convertView.findViewById(R.id.item_date);
            hodler.tmp = (TextView) convertView.findViewById(R.id.item_tmp);
            convertView.setTag(hodler);
            hodler = (Hodler) convertView.getTag();
            String tmp = dailyForecast.tmp[0] + "  " + dailyForecast.tmp[1];
            hodler.tmp.setText(tmp);
            hodler.date.setText(WEEKS[(7+week + i)%7]);
            hodler.icon.setImageDrawable(getDrawable(WeatherData.getWeatherIcon80DrawableId(Integer.parseInt(dailyForecast.cond[0]))));
            weatherDaily.addView(convertView);
            i++;
        }

        hourForecast = (RecyclerView) findViewById(R.id.hour_forecast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        hourForecast.setHasFixedSize(true);
        hourForecast.setLayoutManager(linearLayoutManager);
        hourForecast.setAdapter(new HourForecastAdapter(weatherData.hourlyForecasts));

        weatherToday = (TextView) findViewById(R.id.weather_today);
        StringBuilder sb = new StringBuilder();
        sb.append("今天：")
                .append("风力")
                .append(weatherData.wind)
                .append("\n现在")
                .append(weatherData.cond[1])
                .append("。最高气温")
                .append(weatherData.dailyForecasts[0].tmp[0])
                .append(WeatherConstant.CELSIUS_DEGRESS)
                .append("\n").append("今晚")
                .append(weatherData.dailyForecasts[0].cond[3])
                .append(",最低气温")
                .append(weatherData.dailyForecasts[0].tmp[1])
                .append(WeatherConstant.CELSIUS_DEGRESS);
        weatherToday.setText(sb.toString());

        LinearLayout.LayoutParams LLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LLP.setMargins(80,10,80,10);
        LinearLayout comf = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        comf.setLayoutParams(LLP);
        ((TextView)(comf.findViewById(R.id.suggestion_name))).setText("舒适度指数：");
        ((TextView)(comf.findViewById(R.id.brf))).setText(weatherData.suggestion.comf[0]);
        ((TextView)(comf.findViewById(R.id.txt))).setText(weatherData.suggestion.comf[1]);
        weatherDaily.addView(comf);

        LinearLayout cw = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        cw.setLayoutParams(LLP);
        ((TextView)(cw.findViewById(R.id.suggestion_name))).setText("洗车指数：");
        ((TextView)(cw.findViewById(R.id.brf))).setText(weatherData.suggestion.cw[0]);
        ((TextView)(cw.findViewById(R.id.txt))).setText(weatherData.suggestion.cw[1]);
        weatherDaily.addView(cw);

        LinearLayout drsg = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        drsg.setLayoutParams(LLP);
        ((TextView)(drsg.findViewById(R.id.suggestion_name))).setText("穿衣指数：");
        ((TextView)(drsg.findViewById(R.id.brf))).setText(weatherData.suggestion.drsg[0]);
        ((TextView)(drsg.findViewById(R.id.txt))).setText(weatherData.suggestion.drsg[1]);
        weatherDaily.addView(drsg);

        LinearLayout flu = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        flu.setLayoutParams(LLP);
        ((TextView)(flu.findViewById(R.id.suggestion_name))).setText("感冒指数：");
        ((TextView)(flu.findViewById(R.id.brf))).setText(weatherData.suggestion.flu[0]);
        ((TextView)(flu.findViewById(R.id.txt))).setText(weatherData.suggestion.flu[1]);
        weatherDaily.addView(flu);

        LinearLayout sport = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        sport.setLayoutParams(LLP);
        ((TextView)(sport.findViewById(R.id.suggestion_name))).setText("�?动指数：");
        ((TextView)(sport.findViewById(R.id.brf))).setText(weatherData.suggestion.sport[0]);
        ((TextView)(sport.findViewById(R.id.txt))).setText(weatherData.suggestion.sport[1]);
        weatherDaily.addView(sport);

        LinearLayout trav = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        trav.setLayoutParams(LLP);
        ((TextView)(trav.findViewById(R.id.suggestion_name))).setText("旅游指数：");
        ((TextView)(trav.findViewById(R.id.brf))).setText(weatherData.suggestion.trav[0]);
        ((TextView)(trav.findViewById(R.id.txt))).setText(weatherData.suggestion.trav[1]);
        weatherDaily.addView(trav);

        LinearLayout uv = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.suggestion_item,null);
        uv.setLayoutParams(LLP);
        ((TextView)(uv.findViewById(R.id.suggestion_name))).setText("紫外线指数：");
        ((TextView)(uv.findViewById(R.id.brf))).setText(weatherData.suggestion.uv[0]);
        ((TextView)(uv.findViewById(R.id.txt))).setText(weatherData.suggestion.uv[1]);
        weatherDaily.addView(uv);

    }

