    /**
     * get the instance of the WeatherDB
     */
    public synchronized static WeatherDB getInstance(Context context){
        if(iWeatherDB==null){
            iWeatherDB=new WeatherDB(context);
        }
        return iWeatherDB;
    }

