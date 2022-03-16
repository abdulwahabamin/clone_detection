        public MainViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);

            tvDate = (TextView)itemView.findViewById(R.id.tv_city_weather_main_date);
            tvAirQualityIndex = (TextView)itemView.findViewById(R.id.tv_city_weather_main_air_quality_index);
            tvAirQualityType = (TextView)itemView.findViewById(R.id.tv_city_weather_main_air_quality_type);
            tvWeatherDesc = (TextView)itemView.findViewById(R.id.tv_city_weather_main_weather_desc);
            tvCurTemp = (TextView)itemView.findViewById(R.id.tv_city_weather_main_cur_temp);
            tvUpdateTime = (TextView)itemView.findViewById(R.id.tv_city_weather_main_update_time);
            tvForecastDate1 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_date1);
            tvForecastTemp1 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_temp1);
            ivForecastIcon1 = (ImageView)itemView.findViewById(R.id.iv_city_weather_main_forecast_icon1);
            tvForecastDate2 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_date2);
            tvForecastTemp2 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_temp2);
            ivForecastIcon2 = (ImageView)itemView.findViewById(R.id.iv_city_weather_main_forecast_icon2);
            tvForecastDate3 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_date3);
            tvForecastTemp3 = (TextView)itemView.findViewById(R.id.tv_city_weather_main_forecast_temp3);
            ivForecastIcon3 = (ImageView)itemView.findViewById(R.id.iv_city_weather_main_forecast_icon3);
        }

