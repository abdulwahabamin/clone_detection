    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View rowView = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.row_city_list_with_weather_buttons, parent, false);

        CityRowWeatherViewHolder holder = new CityRowWeatherViewHolder();
        holder.cityNameTextView = (TextView) rowView
                .findViewById(R.id.city_name_in_list_row_text_view);
        holder.buttonCurrentWeather = (LinearLayout) rowView
                .findViewById(R.id.city_current_weather_button);
        holder.buttonDailyForecast = (LinearLayout) rowView
                .findViewById(R.id.city_daily_weather_forecast_button);
        holder.buttonThreeHourlyForecast = (LinearLayout) rowView
                .findViewById(R.id.city_three_hourly_weather_forecast_button);

        holder.buttonCurrentWeather.setOnClickListener(onClickListener);
        holder.buttonDailyForecast.setOnClickListener(onClickListener);
        holder.buttonThreeHourlyForecast.setOnClickListener(onClickListener);

        rowView.setTag(holder);

        return rowView;
    }

