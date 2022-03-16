    @Override
    public void onBindViewHolder(CourseOfDayViewHolder holder, int position) {

        //Time has to be the local time in the city!
        holder.time.setText(StringFormatUtils.formatTime(context, courseOfDayList.get(position).getForecastTime()));
        setIcon(courseOfDayList.get(position).getWeatherID(), holder.weather);
        holder.humidity.setText(StringFormatUtils.formatDecimal(courseOfDayList.get(position).getHumidity(), "%"));
        holder.temperature.setText(StringFormatUtils.formatTemperature(context, courseOfDayList.get(position).getTemperature()));

    }

