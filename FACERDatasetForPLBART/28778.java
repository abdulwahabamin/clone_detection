    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        if (viewHolder.getItemViewType() == OVERVIEW) {
            OverViewHolder holder = (OverViewHolder) viewHolder;
            setImage(currentWeatherDataList.getWeatherID(), holder.weather);

            holder.temperature.setText(StringFormatUtils.formatTemperature(context, currentWeatherDataList.getTemperatureCurrent()));

        } else if (viewHolder.getItemViewType() == DETAILS) {

            DetailViewHolder holder = (DetailViewHolder) viewHolder;
            holder.humidity.setText(StringFormatUtils.formatDecimal(currentWeatherDataList.getHumidity(), "%"));
            holder.pressure.setText(StringFormatUtils.formatDecimal(currentWeatherDataList.getPressure(), " hPa"));
            holder.windspeed.setText(StringFormatUtils.formatDecimal(currentWeatherDataList.getWindSpeed(), " m/s"));

        } else if (viewHolder.getItemViewType() == WEEK) {

            WeekViewHolder holder = (WeekViewHolder) viewHolder;
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.recyclerView.setLayoutManager(layoutManager);
            WeekWeatherAdapter adapter = new WeekWeatherAdapter(forecastList, context);
            holder.recyclerView.setAdapter(adapter);

        } else if (viewHolder.getItemViewType() == DAY) {

            DayViewHolder holder = (DayViewHolder) viewHolder;
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            holder.recyclerView.setLayoutManager(layoutManager);
            CourseOfDayAdapter adapter = new CourseOfDayAdapter(courseDayList, context);
            holder.recyclerView.setAdapter(adapter);

        } else if (viewHolder.getItemViewType() == SUN) {
            SunViewHolder holder = (SunViewHolder) viewHolder;

            holder.sunrise.setText(StringFormatUtils.formatTime(context, currentWeatherDataList.getTimeSunrise()*1000));
            holder.sunset.setText(StringFormatUtils.formatTime(context, currentWeatherDataList.getTimeSunset()*1000));
        }
        //No update for error needed
    }

