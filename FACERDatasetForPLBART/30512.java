    private void initView(View view) {
        language = ContentUtil.SYS_LANG;
        DateTime now = DateTime.now(DateTimeZone.UTC);
        float a = Float.valueOf(tz);
        float minute = a * 60;
        now = now.plusMinutes(((int) minute));
        currentTime = now.toString("HH:mm");
        tvCond = view.findViewById(R.id.tv_today_cond);
        tvTmp = view.findViewById(R.id.tv_today_tmp);
        textViewList.add(tvTmp);
        ivBack = view.findViewById(R.id.iv_back);
        ivLine = view.findViewById(R.id.iv_line2);
        gridAir = view.findViewById(R.id.grid_air);

        rvForecast = view.findViewById(R.id.rv_forecast);

        tvTodayTitle = view.findViewById(R.id.tv_today_title);
        tvForecastTitle = view.findViewById(R.id.tv_forecast_title);
        textViewList.add(tvTodayTitle);
        textViewList.add(tvForecastTitle);
        ivTodayDay = view.findViewById(R.id.iv_today_day);
        ivTodayNight = view.findViewById(R.id.iv_today_night);
        tvTodayMin = view.findViewById(R.id.tv_min_tmp);
        textViewList.add(tvTodayMin);
        tvTodayMax = view.findViewById(R.id.tv_max_tmp);
        textViewList.add(tvTodayMax);
        tvTodayHum = view.findViewById(R.id.tv_today_hum);
        textViewList.add(tvTodayHum);
        tvTodayRain = view.findViewById(R.id.tv_today_rain);
        textViewList.add(tvTodayRain);
        tvTodayPressure = view.findViewById(R.id.tv_today_pressure);
        textViewList.add(tvTodayPressure);
        tvTodayVisible = view.findViewById(R.id.tv_today_visible);
        textViewList.add(tvTodayVisible);
        tvWindDir = view.findViewById(R.id.tv_wind_dir);
        textViewList.add(tvWindDir);
        tvWindSc = view.findViewById(R.id.tv_wind_sc);
        textViewList.add(tvWindSc);

        tvMin = view.findViewById(R.id.tv_min);
        textViewList.add(tvMin);
        tvMax = view.findViewById(R.id.tv_max);
        textViewList.add(tvMax);
        tvRain = view.findViewById(R.id.tv_rain);
        textViewList.add(tvRain);
        tvHum = view.findViewById(R.id.tv_hum);
        textViewList.add(tvHum);
        tvPressure = view.findViewById(R.id.tv_pressure);
        textViewList.add(tvPressure);
        tvVisible = view.findViewById(R.id.tv_visible);
        textViewList.add(tvVisible);

        tvAirTitle = view.findViewById(R.id.air_title);
        textViewList.add(tvAirTitle);
        rvAir = view.findViewById(R.id.rv_air);
        tvAir = view.findViewById(R.id.tv_air);
        textViewList.add(tvAir);
        tvAirNum = view.findViewById(R.id.tv_air_num);
        textViewList.add(tvAirNum);

        TextView tvPm25 = view.findViewById(R.id.tv_pm25);
        textViewList.add(tvPm25);
        tvTodayPm25 = view.findViewById(R.id.tv_today_pm25);
        textViewList.add(tvTodayPm25);
        TextView tvPm10 = view.findViewById(R.id.tv_pm10);
        textViewList.add(tvPm10);
        tvTodayPm10 = view.findViewById(R.id.tv_today_pm10);
        textViewList.add(tvTodayPm10);
        TextView tvSo2 = view.findViewById(R.id.tv_so2);
        textViewList.add(tvSo2);
        tvTodaySo2 = view.findViewById(R.id.tv_today_so2);
        textViewList.add(tvTodaySo2);
        TextView tvNo2 = view.findViewById(R.id.tv_no2);
        textViewList.add(tvNo2);
        tvTodayNo2 = view.findViewById(R.id.tv_today_no2);
        textViewList.add(tvTodayNo2);
        TextView tvCo = view.findViewById(R.id.tv_co);
        textViewList.add(tvCo);
        tvTodayCo = view.findViewById(R.id.tv_today_co);
        textViewList.add(tvTodayCo);
        TextView tvO3 = view.findViewById(R.id.tv_o3);
        textViewList.add(tvO3);
        tvTodayO3 = view.findViewById(R.id.tv_today_o3);
        textViewList.add(tvTodayO3);
        tvLineMin = view.findViewById(R.id.tv_line_min_tmp);
        textViewList.add(tvLineMin);
        tvLineMax = view.findViewById(R.id.tv_line_max_tmp);
        textViewList.add(tvLineMax);
        tvAlarm = view.findViewById(R.id.tv_today_alarm);
        textViewList.add(tvAlarm);

        TextView tvFrom = view.findViewById(R.id.tv_from);
        tvFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUri();
            }
        });

        tvSunTitle = view.findViewById(R.id.tv_sun_title);
        textViewList.add(tvSunTitle);
        sunView = view.findViewById(R.id.sun_view);
        moonView = view.findViewById(R.id.moon_view);

        IndexHorizontalScrollView horizontalScrollView = view.findViewById(R.id.hsv);
        hourlyForecastView = view.findViewById(R.id.hourly);
        horizontalScrollView.setToday24HourView(hourlyForecastView);

        watched.addWatcher(hourlyForecastView);

        //æ¨ªå?‘æ»šåŠ¨ç›‘å?¬
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    watched.notifyWatcher(scrollX);
                }
            });
        }

        swipeRefreshLayout = view.findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(location);
            }
        });

    }

