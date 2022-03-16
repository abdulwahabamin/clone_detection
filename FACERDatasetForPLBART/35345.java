    @SuppressLint("SimpleDateFormat")
    @Override
    public void updateView(HWeather weather) {
        mSwipeLayout.setVisibility(View.VISIBLE);
        mSwipeLayout.setRefreshing(false);
        refresh.clearAnimation();
        refresh.setVisibility(View.GONE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        date.setText("今天" + simpleDateFormat.format(new Date()));
        Date sqlDate = convertDate(WeatherJsonConverter.getWeather(weather).getBasic()
                .getUpdate().getLoc());
        long time = DateUtil.getDifferenceofDate(new Date(), sqlDate) / (1000 * 60);
        if (time > 1000 * 60 * 60 || time < 0) {
            updateTime.setText("最近更新：" + new SimpleDateFormat("MM-dd HH:mm:ss").format(sqlDate));
        } else {
            updateTime.setText("最近更新：" + time + "分钟之�?");
        }
        tempImage.setImageResource(WeatherIcon.getWeatherImage(WeatherJsonConverter.getWeather(weather).getNow().getCond().getCode()));
        mCallback.updateToolBar(WeatherJsonConverter.getWeather(weather).getBasic().getCity());
        //主�?�片
        temp.setText(WeatherJsonConverter.getWeather(weather).getNow().getTmp() + "°");
        tempHigh.setText("高 " + WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getTmp().getMax() + "°");
        tempLow.setText("低 " + WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getTmp().getMin() + "°");
        cloth.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getDrsg().getBrf());
        condition.setText(WeatherJsonConverter.getWeather(weather).getNow().getCond().getTxt());
        if (WeatherJsonConverter.getWeather(weather).getAqi() != null){
            pm.setText(WeatherJsonConverter.getWeather(weather).getAqi().getCity().getPm25());
            qlty.setText(WeatherJsonConverter.getWeather(weather).getAqi().getCity().getQlty());

        }
        hum.setText(WeatherJsonConverter.getWeather(weather).getNow().getHum() + "%");
        wind.setText(WeatherJsonConverter.getWeather(weather).getNow().getWind().getSpd() + "km/h");
        windDir.setText(WeatherJsonConverter.getWeather(weather).getNow().getWind().getDir());
        vis.setText(WeatherJsonConverter.getWeather(weather).getNow().getVis() + "km");
        pres.setText(WeatherJsonConverter.getWeather(weather).getNow().getPres() + "帕");
        uv.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getUv().getBrf());
        sunrise.setText(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getAstro().getSr());
        sunset.setText(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getAstro().getSs());

        //穿衣指数
        clothBrf.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getDrsg().getBrf());
        clothTxt.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getDrsg().getTxt());

        //�?动指数
        sportBrf.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getSport().getBrf());
        sportTxt.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getSport().getTxt());

        //感冒指数
        codeBrf.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getFlu().getBrf());
        coldTxt.setText(WeatherJsonConverter.getWeather(weather).getSuggestion().getFlu().getTxt());

        //未�?�三�?时天气
        if (WeatherJsonConverter.getWeather(weather).getHourly_forecast().size() != 0) {
            weatherCond.setText(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(0).getPop() + "%");
            updateHours.setText(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(0).getDate());
            windHours.setText(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(0).getWind().getDir() + " " +
                    WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(0).getWind().getSc());
            weatherTmp.setText(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(0).getTmp() + "°");
        } else {
            itemFuture.setVisibility(View.GONE);
        }
        hoursWeathers.clear();
        for (int i = 0; i < WeatherJsonConverter.getWeather(weather).getHourly_forecast().size(); i++) {
            HoursWeather hw = new HoursWeather();
            hw.setTmp(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getTmp() + "°");
            hw.setHum(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getHum() + "%");
            hw.setWind_class(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getWind().getSc());
            hw.setWind_deg(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getWind().getDeg());
            hw.setWind_speed(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getWind().getSpd());
            hw.setWind_dir(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getWind().getDir());
            hw.setPop(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getPop() + "%");
            hw.setUpdate(WeatherJsonConverter.getWeather(weather).getHourly_forecast().get(i).getDate());
            hoursWeathers.add(hw);
        }
    }

