    public static int getWeatherIcon80DrawableId(int code){
        //TODO 区分白天和晚上的天气图标
        switch (code){
            case 100:
                return R.drawable.clear_day_80;
            case 101:
            case 102:
            case 103:
                return R.drawable.mostly_cloudy_80;
            case 104:
                return R.drawable.cloudy_weather_80;
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
                return R.drawable.windy_weather_80;
            case 300:
            case 301:
                return R.drawable.rainy_day_80;
            case 302:
            case 303:
                return R.drawable.showcase_80;
            case 305:
            case 306:
            case 307:
            case 308:
                return R.drawable.rainy_weather_80;
            case 401:
            case 402:
            case 403:
                return R.drawable.snow_weather_80;
            case 407:
            case 500:
            case 501:
            case 502:
                return R.drawable.haze_weather_80;
            default:
                return R.drawable.unknown_80;
        }
    }

