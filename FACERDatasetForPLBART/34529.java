    public static String getWeatherIconUriByCode(int code){
        for(WeatherCondition condition : WeatherCondition.values()){
            if(condition.code == code){
                return condition.iconUri;
            }
        }
        return WeatherCondition.Unknown.iconUri;
    }

