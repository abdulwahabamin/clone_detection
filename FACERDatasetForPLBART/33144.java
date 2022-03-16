    @Test
    public void createForecastFor5DaysAtTheEndOfYear() throws Exception {
        //given
        createDetailedWeatherForecastForDay();

        //when
        Set<ForecastUtil.WeatherForecastPerDay> result = ForecastUtil.calculateWeatherForDays(weatherForecastRecord);

        //then
        assertEquals(5, result.size());
    }

