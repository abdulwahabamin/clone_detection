        ThreeHourlyForecastViewHolder(View itemView) {
            super(itemView);
            forecastStartHourTextView = (TextView) itemView.findViewById(R.id.forecast_hour_start);
            temperatureTextView = (TextView) itemView.findViewById(R.id.temperature_text_view);
            conditionsTextView = (TextView) itemView.findViewById(
                    R.id.weather_conditions_text_view);
            conditionsImageView = (ImageView) itemView.findViewById(
                    R.id.weather_conditions_image_view);
            pressureTextView = (TextView) itemView.findViewById(
                    R.id.atmospheric_pressure_text_view);
            humidityTextView = (TextView) itemView.findViewById(R.id.humidity_text_view);
            windTextView = (TextView) itemView.findViewById(R.id.wind_text_view);
        }

