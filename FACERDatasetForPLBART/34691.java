    @SuppressLint("SimpleDateFormat")
    @Override
    public void showCities(List<WeatherEntity> cityEntities) {
        mList.clear();
        if (cityEntities == null || cityEntities.size() == 0) {
            return;
        }
        for (WeatherEntity entity : cityEntities) {
            if (entity == null){
                return;
            }
            HWeather weather = convertObject(entity.getWeather(), HWeather.class);
            CityManageContext context = new CityManageContext();
            context.setTime(new SimpleDateFormat("HH:mm").
                    format(entity.getUpdateTime()));
            context.setTmp(WeatherJsonConverter.getWeather(weather).getNow().getTmp());
            context.setHum(WeatherJsonConverter.getWeather(weather).getNow().getHum());
            context.setCond(WeatherJsonConverter.getWeather(weather).getNow().getCond().getTxt());
            context.setCityName(entity.getCityName());
            context.setCode(WeatherJsonConverter.getWeather(weather).getNow().getCond().getCode());
            mList.add(context);
        }
        mAdapter.notifyDataSetChanged();
    }

