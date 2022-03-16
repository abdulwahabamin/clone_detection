    public void showWeather(){
        //refresh mCountyCode bound to RefreshableView
        mRefreshableView.setData(mCountyCode);
        
        //show weather Info
        String tmpString;
        String[] tmpStrArray;
        
        tmpString="今天   "+wnl_spf.getString("weekDay","周日");
        weekDay.setText(tmpString);
        tmpString=wnl_spf.getString("date_flag","");
        if(!"".equals(tmpString)){
            tmpStrArray=tmpString.split("-");
            tmpString=tmpStrArray[1]+"月"+tmpStrArray[2]+"日";
            sunDay.setText(tmpString);
        }
        tmpString=wnl_spf.getString("nongLi","�??二月二�??八");
        moonDay.setText(tmpString);

        tmpString=mspf.getString("now_tmp","26")+"°";
        now_tmp.setText(tmpString);
        tmpString=mspf.getString("df_tmp_min_day1","23")+"°~"
                +mspf.getString("df_tmp_max_day1","31")+"°";
        now_tmp_range.setText(tmpString);
        tmpString=mspf.getString("aqi_qlty","无");
        now_air_quality.setText(tmpString);
        air_quality_cardView.setCardBackgroundColor(MainActivity.get_aql_color.get(tmpString));
        tmpString=mspf.getString("now_cond_txt","未知");
        now_weather_image.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        now_weather_txt.setText(tmpString);
        tmpString=mspf.getString("now_wind_sc","？");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        now_wind_sc.setText(tmpString);

        tmpString=mspf.getString("aqi_aqi","无");
        aqi.setText(tmpString);
        tmpString=mspf.getString("aqi_pm25","无");
        pm25.setText(tmpString);
        tmpString=mspf.getString("aqi_pm10","无");
        pm10.setText(tmpString);
        tmpString=mspf.getString("aqi_co","无");
        co.setText(tmpString);
        tmpString=mspf.getString("aqi_so2","无");
        so2.setText(tmpString);
        tmpString=mspf.getString("aqi_no2","无");
        no2.setText(tmpString);
        tmpString=mspf.getString("aqi_o3","无");
        o3.setText(tmpString);

        tmpString=mspf.getString("now_fl","无");
        feeling_tmp.setText(tmpString);
        tmpString=mspf.getString("now_hum","无");
        relative_humidity.setText(tmpString);
        tmpString=mspf.getString("now_pcpn","无");
        precipitation.setText(tmpString);
        tmpString=mspf.getString("now_pres","无");
        air_pressure.setText(tmpString);
        tmpString=mspf.getString("now_vis","无");
        visibility.setText(tmpString);
        tmpString=mspf.getString("now_wind_sc","无");
        wind_scale.setText(tmpString);
        tmpString=mspf.getString("now_wind_spd","无");
        wind_speed.setText(tmpString);
        tmpString=mspf.getString("now_wind_deg","无");
        wind_degree.setText(tmpString);
        tmpString=mspf.getString("now_wind_dir","无");
        wind_direction.setText(tmpString);

        tmpString="�?动指数："+mspf.getString("suggestion_sport_brf","无");
        sport_index.setText(tmpString);
        tmpString="感冒指数："+mspf.getString("suggestion_flu_brf","无");
        flu_index.setText(tmpString);
        tmpString="旅游指数："+mspf.getString("suggestion_trav_brf","无");
        travel_index.setText(tmpString);
        tmpString="紫外线指数："+mspf.getString("suggestion_uv_brf","无");
        ultraviolet_index.setText(tmpString);
        tmpString="穿衣指数："+mspf.getString("suggestion_drsg_brf","无");
        wear_index.setText(tmpString);

        mTempTrendView.clearData();
        tmpString=mspf.getString("yestDay_date","");
        if(!TextUtils.isEmpty(tmpString)){
            tmpStrArray=tmpString.split("-");
            tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
            df_date_0.setText(tmpString);

            tmpString=mspf.getString("yestDay_dCond_txt","未知");
            df_cond_day_txt_0.setText(tmpString);
            df_cond_day_image_0.setImageResource(MainActivity.weatherCodeMap.get(tmpString));

            tmpString=mspf.getString("yestDay_nCond_txt","未知");
            df_cond_night_txt_0.setText(tmpString);
            df_cond_night_image_0.setImageResource(MainActivity.weatherCodeMap.get(tmpString));

            tmpString=mspf.getString("yestDay_wind_dir","无");
            df_wind_direction_0.setText(tmpString);
            tmpString=mspf.getString("yestDay_wind_scale","无");
            if(!"微风".equals(tmpString)){
                tmpString=tmpString+"级";
            }
            df_wind_scale_0.setText(tmpString);

            tmpString=mspf.getString("yestDay_tmp_max","");
            mTempTrendView.addTopTemp(tmpString);
            tmpString=mspf.getString("yestDay_tmp_min","");
            mTempTrendView.addLowTemp(tmpString);
            yestDay_day_layout.setVisibility(View.VISIBLE);
            yestDay_night_layout.setVisibility(View.VISIBLE);
            float pxScale= DisplayUtil.pxScale(mActivity);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams((int)(432*pxScale),(int)(150*pxScale));
            mTempTrendView.setLayoutParams(params);

        }

        tmpString=mspf.getString("df_date_day1","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_1.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day1","未知");
        df_cond_day_txt_1.setText(tmpString);
        df_cond_day_image_1.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day1","未知");
        df_cond_night_txt_1.setText(tmpString);
        df_cond_night_image_1.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day1","");
        df_wind_direction_1.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day1","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_1.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day1","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day1","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day2","");
        df_weekday_2.setText(tmpString);
        tmpString=mspf.getString("df_date_day2","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_2.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day2","未知");
        df_cond_day_txt_2.setText(tmpString);
        df_cond_day_image_2.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day2","未知");
        df_cond_night_txt_2.setText(tmpString);
        df_cond_night_image_2.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day2","");
        df_wind_direction_2.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day2","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_2.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day2","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day2","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day3","");
        df_weekday_3.setText(tmpString);
        tmpString=mspf.getString("df_date_day3","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_3.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day3","未知");
        df_cond_day_txt_3.setText(tmpString);
        df_cond_day_image_3.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day3","未知");
        df_cond_night_txt_3.setText(tmpString);
        df_cond_night_image_3.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day3","");
        df_wind_direction_3.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day3","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_3.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day3","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day3","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day4","");
        df_weekday_4.setText(tmpString);
        tmpString=mspf.getString("df_date_day4","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_4.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day4","未知");
        df_cond_day_txt_4.setText(tmpString);
        df_cond_day_image_4.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day4","未知");
        df_cond_night_txt_4.setText(tmpString);
        df_cond_night_image_4.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day4","");
        df_wind_direction_4.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day4","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_4.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day4","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day4","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day5","");
        df_weekday_5.setText(tmpString);
        tmpString=mspf.getString("df_date_day5","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_5.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day5","未知");
        df_cond_day_txt_5.setText(tmpString);
        df_cond_day_image_5.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day5","未知");
        df_cond_night_txt_5.setText(tmpString);
        df_cond_night_image_5.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day5","");
        df_wind_direction_5.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day5","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_5.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day5","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day5","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day6","");
        df_weekday_6.setText(tmpString);
        tmpString=mspf.getString("df_date_day6","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_6.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day6","未知");
        df_cond_day_txt_6.setText(tmpString);
        df_cond_day_image_6.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day6","未知");
        df_cond_night_txt_6.setText(tmpString);
        df_cond_night_image_6.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day6","");
        df_wind_direction_6.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day6","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_6.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day6","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day6","");
        mTempTrendView.addLowTemp(tmpString);

        tmpString=wnl_spf.getString("df_weekDay_day7","");
        df_weekday_7.setText(tmpString);
        tmpString=mspf.getString("df_date_day7","");
        tmpStrArray=tmpString.split("-");
        tmpString=tmpStrArray[1]+"/"+tmpStrArray[2];
        df_date_7.setText(tmpString);
        tmpString=mspf.getString("df_conditionText_d_day7","未知");
        df_cond_day_txt_7.setText(tmpString);
        df_cond_day_image_7.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_conditionText_n_day7","未知");
        df_cond_night_txt_7.setText(tmpString);
        df_cond_night_image_7.setImageResource(MainActivity.weatherCodeMap.get(tmpString));
        tmpString=mspf.getString("df_wind_dir_day7","");
        df_wind_direction_7.setText(tmpString);
        tmpString=mspf.getString("df_wind_sc_day7","");
        if(!"微风".equals(tmpString)){
            tmpString=tmpString+"级";
        }
        df_wind_scale_7.setText(tmpString);
        tmpString=mspf.getString("df_tmp_max_day7","");
        mTempTrendView.addTopTemp(tmpString);
        tmpString=mspf.getString("df_tmp_min_day7","");
        mTempTrendView.addLowTemp(tmpString);
        mTempTrendView.reDraw();
    }

