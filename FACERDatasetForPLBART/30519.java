    @SuppressLint("SetTextI18n")
    @Override
    public void getWeatherForecast(Forecast bean) {
        if (bean != null && bean.getDaily_forecast() != null) {
            weatherForecastBean = bean;
            DateTime now = DateTime.now(DateTimeZone.UTC);
            tz = bean.getBasic().getTz();
            float a = Float.valueOf(tz);
            float minute = a * 60;
            now = now.plusMinutes(((int) minute));
            currentTime = now.toString("HH:mm");
            List<ForecastBase> daily_forecast = bean.getDaily_forecast();

            ForecastBase forecastBase = daily_forecast.get(0);
            String condCodeD = forecastBase.getCond_code_d();
            String condCodeN = forecastBase.getCond_code_n();
            String tmpMin = forecastBase.getTmp_min();
            String tmpMax = forecastBase.getTmp_max();
            sunrise = forecastBase.getSr();
            sunset = forecastBase.getSs();
            moonRise = forecastBase.getMr();
            moonSet = forecastBase.getMs();
            sunView.setTimes(sunrise, sunset, currentTime);
            moonView.setTimes(moonRise, moonSet, currentTime);
            todayMaxTmp = tmpMax;
            todayMinTmp = tmpMin;
            tvTodayMax.setText(tmpMax + "°");
            tvTodayMin.setText(tmpMin + "°");
            ivTodayDay.setImageResource(IconUtils.getDayIconDark(condCodeD));
            ivTodayNight.setImageResource(IconUtils.getNightIconDark(condCodeN));

            if (forecastAdapter == null) {
                forecastAdapter = new ForecastAdapter(getActivity(), daily_forecast);
                rvForecast.setAdapter(forecastAdapter);
                LinearLayoutManager forecastManager = new LinearLayoutManager(getActivity());
                forecastManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvForecast.setLayoutManager(forecastManager);
            } else {
                forecastAdapter.refreshData(getActivity(), daily_forecast);
            }

        }
    }

