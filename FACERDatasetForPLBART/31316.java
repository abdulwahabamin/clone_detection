    @Override
    public Observable<WeatherEntity> getCityWeather(String cityId, boolean fromCache) {
        Map<String, String> params = new android.support.v4.util.ArrayMap<>(2);
        params.put("city", cityId);
        params.put("key", Constants.WEATHER_KEY);

        return weatherInfoService.getCityWeatherInfo(params)
                .map(new Func1<CityWeatherResponse, WeatherEntity>() {
                    @Override
                    public WeatherEntity call(CityWeatherResponse cityWeatherResponse) {
                        if (null == cityWeatherResponse || null == cityWeatherResponse.getCityWeatherInfos()) {
                            throw new WeatherServiceException("no data");
                        }
                        CityWeatherResponse.CityWeatherInfo cityWeatherInfo = cityWeatherResponse.getCityWeatherInfos().get(0);
                        if (null == cityWeatherInfo) {
                            throw new WeatherServiceException("no data");
                        }
                        if (!cityWeatherInfo.getResultCode().equals(Constants.OK)) {
                            throw new WeatherServiceException("error code: " + cityWeatherInfo.getResultCode());
                        }
                        WeatherEntity weatherEntity = new WeatherEntity();

                        CityWeatherResponse.CityWeatherInfo.Basic basic = cityWeatherInfo.getBasic();
                        if (basic != null) {
                            if (basic.getId() != null)
                                weatherEntity.setCityId(basic.getId());
                            if (basic.getCity() != null)
                                weatherEntity.setCityName(basic.getCity());
                            if (basic.getUpdate() != null && basic.getUpdate().getLoc() != null)
                                weatherEntity.setDataUpdateTime(basic.getUpdate().getLoc());
                        }

                        CityWeatherResponse.CityWeatherInfo.Aqi aqi = cityWeatherInfo.getAqi();
                        if (aqi != null) {
                            CityWeatherResponse.CityWeatherInfo.Aqi.City city = aqi.getCity();
                            if (city != null) {
                                if (city.getAqi() != null)
                                    weatherEntity.setAirQulityIndex(city.getAqi());
                                if (city.getPm25() != null)
                                    weatherEntity.setPm25(city.getPm25());
                                if (city.getPm10() != null)
                                    weatherEntity.setPm10(city.getPm10());
                                if (city.getSo2() != null)
                                    weatherEntity.setSo2(city.getSo2());
                                if (city.getNo2() != null)
                                    weatherEntity.setNo2(city.getNo2());
                                if (city.getCo() != null)
                                    weatherEntity.setCo(city.getCo());
                                if (city.getO3() != null)
                                    weatherEntity.setO3(city.getO3());
                                if (city.getQlty() != null)
                                    weatherEntity.setAirQulityType(city.getQlty());
                            }
                        }

                        CityWeatherResponse.CityWeatherInfo.Now now = cityWeatherInfo.getNow();
                        if (now != null) {
                            CityWeatherResponse.CityWeatherInfo.Now.Cond cond = now.getCond();
                            if (cond != null) {
                                if (cond.getCode() != null)
                                    weatherEntity.setWeatherCode(cond.getCode());
                                if (cond.getTxt() != null)
                                    weatherEntity.setWeatherDescription(cond.getTxt());
                            }
                            if (now.getTmp() != null)
                                weatherEntity.setCurrentTemperature(now.getTmp());
                            if (now.getFl() != null)
                                weatherEntity.setFeltTemperature(now.getFl());
                            if (now.getPcpn() != null)
                                weatherEntity.setRainfall(now.getPcpn());
                            if (now.getHum() != null)
                                weatherEntity.setHumidity(now.getHum());
                            if (now.getPres() != null)
                                weatherEntity.setAirPressure(now.getPres());
                            if (now.getVis() != null)
                                weatherEntity.setVisibility(now.getVis());
                            CityWeatherResponse.CityWeatherInfo.Now.Wind wind = now.getWind();
                            if (wind != null) {
                                if (wind.getSpd() != null)
                                    weatherEntity.setWindSpeed(wind.getSpd());
                                if (wind.getSc() != null)
                                    weatherEntity.setWindScale(wind.getSc());
                                if (wind.getDir() != null)
                                    weatherEntity.setWindDirection(wind.getDir());
                            }
                        }

                        CityWeatherResponse.CityWeatherInfo.Suggestion suggestion = cityWeatherInfo.getSuggestion();
                        if (suggestion != null) {
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Drsg drsg = suggestion.getDrsg();
                            if (drsg != null) {
                                if (drsg.getBrf() != null)
                                    weatherEntity.setDressBrief(drsg.getBrf());
                                if (drsg.getTxt() != null)
                                    weatherEntity.setDressDescription(drsg.getTxt());
                            }
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Uv uv = suggestion.getUv();
                            if (uv != null) {
                                if (uv.getBrf() != null)
                                    weatherEntity.setUvBrief(uv.getBrf());
                                if (uv.getTxt() != null)
                                    weatherEntity.setUvDescription(uv.getTxt());
                            }
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Cw cw = suggestion.getCw();
                            if (cw != null) {
                                if (cw.getBrf() != null)
                                    weatherEntity.setCarWashBrief(cw.getBrf());
                                if (cw.getTxt() != null)
                                    weatherEntity.setCarWashDescription(cw.getTxt());
                            }
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Trav trav = suggestion.getTrav();
                            if (trav != null) {
                                if (trav.getBrf() != null)
                                    weatherEntity.setTravelBrief(trav.getBrf());
                                if (trav.getTxt() != null)
                                    weatherEntity.setTravelDescription(trav.getTxt());
                            }
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Flu flu = suggestion.getFlu();
                            if (flu != null) {
                                if (flu.getBrf() != null)
                                    weatherEntity.setFluBrief(flu.getBrf());
                                if (flu.getTxt() != null)
                                    weatherEntity.setFluDescription(flu.getTxt());
                            }
                            CityWeatherResponse.CityWeatherInfo.Suggestion.Sport sport = suggestion.getSport();
                            if (sport != null) {
                                if (sport.getBrf() != null)
                                    weatherEntity.setSportBrief(sport.getBrf());
                                if (sport.getTxt() != null)
                                    weatherEntity.setSportDescription(sport.getTxt());
                            }
                        }

                        mForecasts.clear();
                        List<CityWeatherResponse.CityWeatherInfo.DailyForecast> forecastsResponse = cityWeatherInfo.getDaily_forecast();
                        if (forecastsResponse != null) {
                            for (CityWeatherResponse.CityWeatherInfo.DailyForecast forecastResponse :
                                    forecastsResponse) {
                                if (forecastResponse != null) {
                                    WeatherEntity.Forecast forcast = new WeatherEntity.Forecast();

                                    if (forecastResponse.getDate() != null)
                                        forcast.setDate(forecastResponse.getDate());

                                    CityWeatherResponse.CityWeatherInfo.DailyForecast.Astro astro = forecastResponse.getAstro();
                                    if (astro != null) {
                                        if (astro.getSr() != null)
                                            forcast.setSunriseTime(astro.getSr());
                                        if (astro.getSs() != null)
                                            forcast.setSunsetTime(astro.getSs());
                                    }

                                    CityWeatherResponse.CityWeatherInfo.DailyForecast.Tmp tmp = forecastResponse.getTmp();
                                    if (tmp != null) {
                                        forcast.setMaxTemperature(tmp.getMax());
                                        forcast.setMinTemperature(tmp.getMin());
                                    }

                                    CityWeatherResponse.CityWeatherInfo.DailyForecast.Wind wind = forecastResponse.getWind();
                                    if (wind != null) {
                                        if (wind.getSpd() != null)
                                            forcast.setWindSpeed(wind.getSpd());
                                        if (wind.getSc() != null)
                                            forcast.setWindScale(wind.getSc());
                                        if (wind.getDir() != null)
                                            forcast.setWindDirection(wind.getDir());
                                    }

                                    CityWeatherResponse.CityWeatherInfo.DailyForecast.Cond cond = forecastResponse.getCond();
                                    if (cond != null) {
                                        if (cond.getCode_d() != null)
                                            forcast.setWeatherCodeDaytime(cond.getCode_d());
                                        if (cond.getCode_n() != null)
                                            forcast.setWeatherCodeNight(cond.getCode_n());
                                        if (cond.getTxt_d() != null)
                                            forcast.setWeatherDescriptionDaytime(cond.getTxt_d());
                                        if (cond.getTxt_n() != null)
                                            forcast.setWeatherDescriptionNight(cond.getTxt_n());
                                    }

                                    if (forecastResponse.getPcpn() != null)
                                        forcast.setRainfall(forecastResponse.getPcpn());
                                    if (forecastResponse.getPop() != null)
                                        forcast.setRainProbability(forecastResponse.getPop());
                                    if (forecastResponse.getHum() != null)
                                        forcast.setHumidity(forecastResponse.getHum());
                                    if (forecastResponse.getPres() != null)
                                        forcast.setAirPressure(forecastResponse.getPres());
                                    if (forecastResponse.getVis() != null)
                                        forcast.setVisibility(forecastResponse.getVis());

                                    mForecasts.add(forcast);
                                }
                            }
                        }
                        weatherEntity.setForecasts(mForecasts);

                        return weatherEntity;
                    }
                });
    }

