    @Test
    public void testFetchingWeatherInfo() throws Exception {
        County county = new County();
        county.setCode("CN101190201");
        WeatherInfo info = WeatherInfoFetcher.fetch(county);
        assert info != null;
        System.out.println(info.toString());
    }

