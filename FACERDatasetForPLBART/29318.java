    private void initWidgets(View view){
        weekDay=(TextView)view.findViewById(R.id.week_day);
        sunDay=(TextView)view.findViewById(R.id.sun_day);
        moonDay=(TextView)view.findViewById(R.id.moon_day);
        now_tmp=(TextView)view.findViewById(R.id.now_tmp);
        now_tmp_range=(TextView)view.findViewById(R.id.now_tmp_range);
        now_air_quality=(TextView)view.findViewById(R.id.air_quality);
        air_quality_cardView=(CardView)view.findViewById(R.id.air_quality_cardView);
        now_weather_image=(ImageView)view.findViewById(R.id.now_weather_image);
        now_weather_txt=(TextView)view.findViewById(R.id.now_weather_txt);
        now_wind_sc=(TextView)view.findViewById(R.id.now_wind_sc);

        aqi=(TextView)view.findViewById(R.id.aqi);
        pm25=(TextView)view.findViewById(R.id.pm25);
        pm10=(TextView)view.findViewById(R.id.pm10);
        co=(TextView)view.findViewById(R.id.co);
        so2=(TextView)view.findViewById(R.id.so2);
        no2=(TextView)view.findViewById(R.id.no2);
        o3=(TextView)view.findViewById(R.id.o3);

        feeling_tmp=(TextView)view.findViewById(R.id.feeling_tmp);
        relative_humidity=(TextView)view.findViewById(R.id.relative_humidity);
        precipitation=(TextView)view.findViewById(R.id.precipitation);
        air_pressure=(TextView)view.findViewById(R.id.air_pressure);
        visibility=(TextView)view.findViewById(R.id.visibility);
        wind_scale=(TextView)view.findViewById(R.id.wind_scale);
        wind_speed=(TextView)view.findViewById(R.id.wind_speed);
        wind_degree=(TextView)view.findViewById(R.id.wind_degree);
        wind_direction=(TextView)view.findViewById(R.id.wind_orientation);

        sport_index=(TextView)view.findViewById(R.id.sport_index);
        flu_index=(TextView)view.findViewById(R.id.flu_index);
        travel_index=(TextView)view.findViewById(R.id.travel_index);
        ultraviolet_index=(TextView)view.findViewById(R.id.ultraviolet_index);
        wear_index=(TextView)view.findViewById(R.id.wear_index);

        df_weekday_0=(TextView)view.findViewById(R.id.df_weekday_0);
        df_weekday_1=(TextView)view.findViewById(R.id.df_weekday_1);
        df_weekday_2=(TextView)view.findViewById(R.id.df_weekday_2);
        df_weekday_3=(TextView)view.findViewById(R.id.df_weekday_3);
        df_weekday_4=(TextView)view.findViewById(R.id.df_weekday_4);
        df_weekday_5=(TextView)view.findViewById(R.id.df_weekday_5);
        df_weekday_6=(TextView)view.findViewById(R.id.df_weekday_6);
        df_weekday_7=(TextView)view.findViewById(R.id.df_weekday_7);

        df_date_0=(TextView)view.findViewById(R.id.df_date_0);
        df_date_1=(TextView)view.findViewById(R.id.df_date_1);
        df_date_2=(TextView)view.findViewById(R.id.df_date_2);
        df_date_3=(TextView)view.findViewById(R.id.df_date_3);
        df_date_4=(TextView)view.findViewById(R.id.df_date_4);
        df_date_5=(TextView)view.findViewById(R.id.df_date_5);
        df_date_6=(TextView)view.findViewById(R.id.df_date_6);
        df_date_7=(TextView)view.findViewById(R.id.df_date_7);

        df_cond_day_txt_0=(TextView)view.findViewById(R.id.df_cond_day_txt_0);
        df_cond_day_txt_1=(TextView)view.findViewById(R.id.df_cond_day_txt_1);
        df_cond_day_txt_2=(TextView)view.findViewById(R.id.df_cond_day_txt_2);
        df_cond_day_txt_3=(TextView)view.findViewById(R.id.df_cond_day_txt_3);
        df_cond_day_txt_4=(TextView)view.findViewById(R.id.df_cond_day_txt_4);
        df_cond_day_txt_5=(TextView)view.findViewById(R.id.df_cond_day_txt_5);
        df_cond_day_txt_6=(TextView)view.findViewById(R.id.df_cond_day_txt_6);
        df_cond_day_txt_7=(TextView)view.findViewById(R.id.df_cond_day_txt_7);

        df_cond_day_image_0=(ImageView)view.findViewById(R.id.df_cond_day_image_0);
        df_cond_day_image_1=(ImageView)view.findViewById(R.id.df_cond_day_image_1);
        df_cond_day_image_2=(ImageView)view.findViewById(R.id.df_cond_day_image_2);
        df_cond_day_image_3=(ImageView)view.findViewById(R.id.df_cond_day_image_3);
        df_cond_day_image_4=(ImageView)view.findViewById(R.id.df_cond_day_image_4);
        df_cond_day_image_5=(ImageView)view.findViewById(R.id.df_cond_day_image_5);
        df_cond_day_image_6=(ImageView)view.findViewById(R.id.df_cond_day_image_6);
        df_cond_day_image_7=(ImageView)view.findViewById(R.id.df_cond_day_image_7);

        df_cond_night_image_0=(ImageView)view.findViewById(R.id.df_cond_night_image_0);
        df_cond_night_image_1=(ImageView)view.findViewById(R.id.df_cond_night_image_1);
        df_cond_night_image_2=(ImageView)view.findViewById(R.id.df_cond_night_image_2);
        df_cond_night_image_3=(ImageView)view.findViewById(R.id.df_cond_night_image_3);
        df_cond_night_image_4=(ImageView)view.findViewById(R.id.df_cond_night_image_4);
        df_cond_night_image_5=(ImageView)view.findViewById(R.id.df_cond_night_image_5);
        df_cond_night_image_6=(ImageView)view.findViewById(R.id.df_cond_night_image_6);
        df_cond_night_image_7=(ImageView)view.findViewById(R.id.df_cond_night_image_7);

        df_cond_night_txt_0=(TextView)view.findViewById(R.id.df_cond_night_txt_0);
        df_cond_night_txt_1=(TextView)view.findViewById(R.id.df_cond_night_txt_1);
        df_cond_night_txt_2=(TextView)view.findViewById(R.id.df_cond_night_txt_2);
        df_cond_night_txt_3=(TextView)view.findViewById(R.id.df_cond_night_txt_3);
        df_cond_night_txt_4=(TextView)view.findViewById(R.id.df_cond_night_txt_4);
        df_cond_night_txt_5=(TextView)view.findViewById(R.id.df_cond_night_txt_5);
        df_cond_night_txt_6=(TextView)view.findViewById(R.id.df_cond_night_txt_6);
        df_cond_night_txt_7=(TextView)view.findViewById(R.id.df_cond_night_txt_7);

        df_wind_direction_0=(TextView)view.findViewById(R.id.df_wind_direction_0);
        df_wind_direction_1=(TextView)view.findViewById(R.id.df_wind_direction_1);
        df_wind_direction_2=(TextView)view.findViewById(R.id.df_wind_direction_2);
        df_wind_direction_3=(TextView)view.findViewById(R.id.df_wind_direction_3);
        df_wind_direction_4=(TextView)view.findViewById(R.id.df_wind_direction_4);
        df_wind_direction_5=(TextView)view.findViewById(R.id.df_wind_direction_5);
        df_wind_direction_6=(TextView)view.findViewById(R.id.df_wind_direction_6);
        df_wind_direction_7=(TextView)view.findViewById(R.id.df_wind_direction_7);

        df_wind_scale_0=(TextView)view.findViewById(R.id.df_wind_scale_0);
        df_wind_scale_1=(TextView)view.findViewById(R.id.df_wind_scale_1);
        df_wind_scale_2=(TextView)view.findViewById(R.id.df_wind_scale_2);
        df_wind_scale_3=(TextView)view.findViewById(R.id.df_wind_scale_3);
        df_wind_scale_4=(TextView)view.findViewById(R.id.df_wind_scale_4);
        df_wind_scale_5=(TextView)view.findViewById(R.id.df_wind_scale_5);
        df_wind_scale_6=(TextView)view.findViewById(R.id.df_wind_scale_6);
        df_wind_scale_7=(TextView)view.findViewById(R.id.df_wind_scale_7);

        yestDay_day_layout=(LinearLayout)view.findViewById(R.id.yestDay_day_layout);
        yestDay_night_layout=(LinearLayout)view.findViewById(R.id.yestDay_night_layout);
        mTempTrendView=(TemperatureTrendView)view.findViewById(R.id.daily_forecast_tmp_trend_view);

        mRefreshableView=(RefreshableView) view.findViewById(R.id.refreshable_view_layout);
        mRefreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
    }

