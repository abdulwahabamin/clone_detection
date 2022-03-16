    @Test
    public void calculateMaxTemperatureWhenAllValuesAreNegative() throws Exception {
        //given
        createDetailedWeatherForecastForDayWithNegativeTemperatures();

        //when
        Set<ForecastUtil.WeatherForecastPerDay> result = ForecastUtil.calculateWeatherForDays(weatherForecastRecord);

        //then
        assertEquals(1, result.size());
        ForecastUtil.WeatherForecastPerDay firstDay = result.iterator().next();
        assertTrue(firstDay.weatherMaxMinForDay.maxTemp > firstDay.weatherMaxMinForDay.minTemp);
        assertTrue(0 > firstDay.weatherMaxMinForDay.minTemp);
        assertTrue(0 > firstDay.weatherMaxMinForDay.maxTemp);
    }

