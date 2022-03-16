        public ViewHolder(View itemView) {
            //ButterKnife.bind(this, itemView);
            tvDate = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_date);
            tvCentigrade = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_centigrade);
            tvWeatherDesc = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_weather_desc);
        }

