        public WeatherForecastPerDay(
                int dayIndex,
                WeatherIdsForDay weatherIds,
                WeatherMaxMinForDay weatherMaxMinForDay,
                String iconId,
                int dayInYear,
                int year) {
            this.dayIndex = dayIndex;
            this.iconId = iconId;
            this.weatherIds = weatherIds;
            this.weatherMaxMinForDay = weatherMaxMinForDay;
            this.year = year;
            this.dayInYear = dayInYear;
        }

