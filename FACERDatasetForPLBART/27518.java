  public WeatherStreamDBWeatherStreamDB_Database(DatabaseHolder holder) {
    addModelAdapter(new Clouds_Table(this), holder);
    addModelAdapter(new Coord_Table(this), holder);
    addModelAdapter(new ForecastList_Table(this), holder);
    addModelAdapter(new LocationSearchHistory_Table(this), holder);
    addModelAdapter(new Main_Table(this), holder);
    addModelAdapter(new Rain_Table(this), holder);
    addModelAdapter(new Sys_Table(this), holder);
    addModelAdapter(new WeatherData_Table(this), holder);
    addModelAdapter(new WeatherForecastData_Table(this), holder);
    addModelAdapter(new Weather_Table(this), holder);
    addModelAdapter(new Wind_Table(this), holder);
  }

