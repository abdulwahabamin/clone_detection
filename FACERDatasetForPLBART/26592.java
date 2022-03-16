    @Override
    public void onBindViewHolder(ForecastOverviewAdapter.ViewHolder holder, int position) {
        weatherHelper = new WeatherHelper();
        // Get the data model based on position
        Day songs = users.get(position);
        // Set item views based on the data model
        Integer timestamp = songs.time;
        Date time = new Date((long)timestamp*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd.");
        holder.tvDayName.setText(sdf.format(time));
        holder.tvDescription.setText(songs.description);
        String temp =  String.format("%.1f", songs.max_temp);
        holder.tvTemperature.setText(temp + "°");
        holder.ivWeatheric.setImageResource(weatherHelper.convertWeather(songs.weatherid));

        holder.cvCard.setBackgroundColor(context.getResources().getColor(WeatherHelper.convertWeatherToColor(songs.weatherid)));
    }

