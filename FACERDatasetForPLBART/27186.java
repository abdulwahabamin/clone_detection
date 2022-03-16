    private void addDaysToViewPager(List<OrmWeather> hours) {
        List<DayPager> days = new ArrayList<>();
        Calendar firstDate = Calendar.getInstance();
        firstDate.setTime(hours.get(0).getDt());
        DayPager day = new DayPager();
        day.setHours(new ArrayList<OrmWeather>());
        days.add(day);
        for (OrmWeather hourWeather : hours) {
            Calendar nextDate = Calendar.getInstance();
            nextDate.setTime(hourWeather.getDt());
            if (firstDate.get(Calendar.YEAR) == nextDate.get(Calendar.YEAR)
                    && firstDate.get(Calendar.DAY_OF_YEAR) - nextDate.get(Calendar.DAY_OF_YEAR) == 0) {
                day.getHours().add(hourWeather);
            } else {
                day = new DayPager();
                day.setHours(new ArrayList<OrmWeather>());
                day.getHours().add(hourWeather);
                days.add(day);
            }
            firstDate = nextDate;
        }
        addDays(days);
    }

