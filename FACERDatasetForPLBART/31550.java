    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (null == mWeatherEntity)
            return;

        if (0 == position) {
            MainViewHolder mainViewHolder = (MainViewHolder)holder;
            mainViewHolder.tvDate.setText(StringUtil.getCurrentDateTime("yyyy-MM-dd\nEEEE"));
            mainViewHolder.tvAirQualityIndex.setText(mWeatherEntity.getAirQulityIndex());
            AirQulityRepresentation airQulityRepresentation = new AirQulityRepresentation();
            getAirQualityTypeAndColor(mWeatherEntity.getAirQulityIndex(), airQulityRepresentation);
            mainViewHolder.tvAirQualityType.setText(airQulityRepresentation.getmAirQulityType());
            GradientDrawable shapeDrawable = (GradientDrawable)mainViewHolder.tvAirQualityType.getBackground();
            shapeDrawable.setColor(mContext.getResources().getColor(airQulityRepresentation.getmAirQulityColorId()));
            mainViewHolder.tvCurTemp.setText(mWeatherEntity.getCurrentTemperature());
            String[] dateAndTime = mWeatherEntity.getDataUpdateTime().split(" ");
            Date date = StringUtil.stringToDate("yyyy-MM-dd", dateAndTime[0]);
            mainViewHolder.tvUpdateTime.setText(StringUtil.getFriendlyDateString(date, false) + " " + dateAndTime[1] + " �?�布");
            mainViewHolder.tvWeatherDesc.setText(mWeatherEntity.getWeatherDescription());

            if (mListForecasts.size() >= 3) {
                Date date0 = StringUtil.stringToDate("yyyy-MM-dd", mListForecasts.get(0).getDate());
                mainViewHolder.tvForecastDate1.setText(StringUtil.getFriendlyDateString(date0, true));
                mainViewHolder.tvForecastTemp1.setText(mListForecasts.get(0).getMinTemperature() + " ~ " + mListForecasts.get(0).getMaxTemperature() + "℃");
                mPresenter.getImageViewSrc(mainViewHolder.ivForecastIcon1, getWeatherIconId(mListForecasts.get(0).getWeatherDescriptionDaytime()));

                Date date1 = StringUtil.stringToDate("yyyy-MM-dd", mListForecasts.get(1).getDate());
                mainViewHolder.tvForecastDate2.setText(StringUtil.getFriendlyDateString(date1, true));
                mainViewHolder.tvForecastTemp2.setText(mListForecasts.get(1).getMinTemperature() + " ~ " + mListForecasts.get(1).getMaxTemperature() + "℃");
                mPresenter.getImageViewSrc(mainViewHolder.ivForecastIcon2, getWeatherIconId(mListForecasts.get(1).getWeatherDescriptionDaytime()));

                Date date2 = StringUtil.stringToDate("yyyy-MM-dd", mListForecasts.get(2).getDate());
                mainViewHolder.tvForecastDate3.setText(StringUtil.getFriendlyDateString(date2, true));
                mainViewHolder.tvForecastTemp3.setText(mListForecasts.get(2).getMinTemperature() + " ~ " + mListForecasts.get(2).getMaxTemperature() + "℃");
                mPresenter.getImageViewSrc(mainViewHolder.ivForecastIcon3, getWeatherIconId(mListForecasts.get(2).getWeatherDescriptionDaytime()));
            }
        } else if (1 == position) {
            ForecastViewHolder forecastViewHolder = (ForecastViewHolder)holder;
            forecastViewHolder.tvTitleName.setText(R.string.forecast_title);
            //forecastViewHolder.lvCityWeatherForecast.setAdapter(mForecastAdapter);

            int index = 0;
            for (WeatherEntity.Forecast forecast : mListForecasts) {
                ++index;
                switch (index) {
                    case 1: {
                        Date date1 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate1.setText(StringUtil.getFriendlyDateString(date1, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon1, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc1.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade1.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale1.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir1.setText(forecast.getWindDirection());
                    } break;
                    case 2: {
                        Date date2 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate2.setText(StringUtil.getFriendlyDateString(date2, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon2, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc2.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade2.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale2.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir2.setText(forecast.getWindDirection());
                    } break;
                    case 3: {
                        Date date3 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate3.setText(StringUtil.getFriendlyDateString(date3, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon3, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc3.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade3.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale3.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir3.setText(forecast.getWindDirection());
                    } break;
                    case 4: {
                        Date date4 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate4.setText(StringUtil.getFriendlyDateString(date4, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon4, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc4.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade4.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale4.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir4.setText(forecast.getWindDirection());
                    } break;
                    case 5: {
                        Date date5 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate5.setText(StringUtil.getFriendlyDateString(date5, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon5, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc5.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade5.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale5.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir5.setText(forecast.getWindDirection());
                    } break;
                    case 6: {
                        Date date6 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate6.setText(StringUtil.getFriendlyDateString(date6, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon6, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc6.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade6.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale6.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir6.setText(forecast.getWindDirection());
                    } break;
                    case 7: {
                        Date date7 = StringUtil.stringToDate("yyyy-MM-dd", forecast.getDate());
                        forecastViewHolder.tvDate7.setText(StringUtil.getFriendlyDateString(date7, true));
                        mPresenter.getImageViewSrc(forecastViewHolder.ivIcon7, getWeatherIconId(forecast.getWeatherDescriptionDaytime()));
                        forecastViewHolder.tvDesc7.setText(forecast.getWeatherDescriptionDaytime());
                        forecastViewHolder.tvCentigrade7.setText(forecast.getMinTemperature() + " ~ " + forecast.getMaxTemperature() + "℃");
                        forecastViewHolder.tvWindScale7.setText(forecast.getWindScale());
                        forecastViewHolder.tvWindDir7.setText(forecast.getWindDirection());
                    } break;
                }
            }

        } else if (2 == position) {
            CurWeatherInfoViewHolder curWeatherInfoViewHolder = (CurWeatherInfoViewHolder)holder;
            curWeatherInfoViewHolder.tvTitleName.setText(R.string.current_weather_info);
            //curWeatherInfoViewHolder.gvCurWeatherInfo.setAdapter(mCurWeatherInfoAdapter);

            int index = 0;
            for (CurWeatherInfoWrapper info: mListWeatherInfo) {
                ++index;
                switch (index) {
                    case 1: {
                        mPresenter.getImageViewSrc(curWeatherInfoViewHolder.ivIcon1, R.drawable.ic_winddirect);
                        curWeatherInfoViewHolder.tvName1.setText(info.getWeatherInfoName());
                        curWeatherInfoViewHolder.tvValue1.setText(info.getWeatherInfoValue());
                    } break;
                    case 2: {
                        mPresenter.getImageViewSrc(curWeatherInfoViewHolder.ivIcon2, R.drawable.ic_windspeed);
                        curWeatherInfoViewHolder.tvName2.setText(info.getWeatherInfoName());
                        curWeatherInfoViewHolder.tvValue2.setText(info.getWeatherInfoValue());
                    } break;
                    case 3: {
                        mPresenter.getImageViewSrc(curWeatherInfoViewHolder.ivIcon3, R.drawable.ic_sun_rise);
                        curWeatherInfoViewHolder.tvName3.setText(info.getWeatherInfoName());
                        curWeatherInfoViewHolder.tvValue3.setText(info.getWeatherInfoValue());
                    } break;
                    case 4: {
                        mPresenter.getImageViewSrc(curWeatherInfoViewHolder.ivIcon4, R.drawable.ic_sunset);
                        curWeatherInfoViewHolder.tvName4.setText(info.getWeatherInfoName());
                        curWeatherInfoViewHolder.tvValue4.setText(info.getWeatherInfoValue());
                    } break;
                    case 5: {
                        mPresenter.getImageViewSrc(curWeatherInfoViewHolder.ivIcon5, R.drawable.ic_sun_rise);
                        curWeatherInfoViewHolder.tvName5.setText(info.getWeatherInfoName());
                        curWeatherInfoViewHolder.tvValue5.setText(info.getWeatherInfoValue());
                    } break;
                }
            }
        } else {
            LifeIndexViewHolder lifeIndexViewHolder = (LifeIndexViewHolder)holder;
            lifeIndexViewHolder.tvTitleName.setText(R.string.life_index);
            //lifeIndexViewHolder.lvLifeIndex.setAdapter(mLifeIndexAdapter);

            int index = 0;
            for (LifeIndexWrapper lifeIndex : mListLifeIndex) {
                ++index;
                switch (index) {
                    case 1: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon1, R.drawable.ic_life_info_chuanyi);
                        lifeIndexViewHolder.tvName1.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief1.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc1.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow1, R.drawable.arrow_close);
                    } break;
                    case 2: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon2, R.drawable.ic_life_info_ziwaixian);
                        lifeIndexViewHolder.tvName2.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief2.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc2.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow2, R.drawable.arrow_close);
                    } break;
                    case 3: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon3, R.drawable.ic_life_info_xiche);
                        lifeIndexViewHolder.tvName3.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief3.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc3.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow3, R.drawable.arrow_close);
                    } break;
                    case 4: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon4, R.drawable.ic_life_info_diaoyu);
                        lifeIndexViewHolder.tvName4.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief4.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc4.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow4, R.drawable.arrow_close);
                    } break;
                    case 5: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon5, R.drawable.ic_life_info_ganmao);
                        lifeIndexViewHolder.tvName5.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief5.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc5.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow5, R.drawable.arrow_close);
                    } break;
                    case 6: {
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivIcon6, R.drawable.ic_life_info_yundong);
                        lifeIndexViewHolder.tvName6.setText(lifeIndex.getLifeIndexName());
                        lifeIndexViewHolder.tvBrief6.setText(lifeIndex.getLifeIndexBrief());
                        lifeIndexViewHolder.tvDesc6.setText(lifeIndex.getLifeIndexDesc());
                        mPresenter.getImageViewSrc(lifeIndexViewHolder.ivArrow6, R.drawable.arrow_close);
                    } break;
                }
            }
        }
    }

