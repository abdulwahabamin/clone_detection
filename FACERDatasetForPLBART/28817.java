    @Override
    public void onBindViewHolder(WeekForecastViewHolder holder, int position) {
        Forecast f = forecastList.get(position);

        setIcon(f.getWeatherID(), holder.weather);
        holder.humidity.setText(StringFormatUtils.formatDecimal(f.getHumidity(), "%"));

        Calendar c = new GregorianCalendar();
        c.setTime(f.getForecastTime());
        int day = c.get(Calendar.DAY_OF_WEEK);

        switch(day) {
            case Calendar.MONDAY:
                day = R.string.abbreviation_monday;
                break;
            case Calendar.TUESDAY:
                day = R.string.abbreviation_tuesday;
                break;
            case Calendar.WEDNESDAY:
                day = R.string.abbreviation_wednesday;
                break;
            case Calendar.THURSDAY:
                day = R.string.abbreviation_thursday;
                break;
            case Calendar.FRIDAY:
                day = R.string.abbreviation_friday;
                break;
            case Calendar.SATURDAY:
                day = R.string.abbreviation_saturday;
                break;
            case Calendar.SUNDAY:
                day = R.string.abbreviation_sunday;
                break;
            default:
                day = R.string.abbreviation_monday;
        }
        holder.day.setText(day);
        holder.temperature.setText(StringFormatUtils.formatTemperature(context, f.getTemperature()));
    }

