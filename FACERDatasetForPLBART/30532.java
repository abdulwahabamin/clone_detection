    private void changeLang() {
        initData(location);
//        setWeeks(tvWeekList);
        if (forecastAdapter != null) {
            forecastAdapter.notifyDataSetChanged();
        }
        tvTodayTitle.setText(R.string.today_title);
        tvForecastTitle.setText(R.string.forecast);
        tvMin.setText(R.string.min_tmp);
        tvMax.setText(R.string.max_tmp);
        tvHum.setText(R.string.hum);
        tvRain.setText(R.string.rainfall);
        tvPressure.setText(R.string.pressure);
        tvVisible.setText(R.string.visible);
        tvAirTitle.setText(R.string.air_quality);
        tvSunTitle.setText(R.string.sun_moon);
        if (!TextUtils.isEmpty(sunrise) && !TextUtils.isEmpty(sunset) && !TextUtils.isEmpty(moonRise) && !TextUtils.isEmpty(moonSet)) {
            DateTime now = DateTime.now(DateTimeZone.UTC);
            float a = Float.valueOf(tz);
            float minute = a * 60;
            now = now.plusMinutes(((int) minute));
            currentTime = now.toString("HH:mm");
            sunView.setTimes(sunrise, sunset, currentTime);
            moonView.setTimes(moonRise, moonSet, currentTime);
            hasAni = true;
        }
    }

