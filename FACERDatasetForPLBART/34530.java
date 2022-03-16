    public static int getWeatherIconDrawableId(int code){
        //TODO 区分白天和晚上的天气图标
        switch (code){
            case 100:
                return R.drawable.clear_day;
            case 101:
            case 102:
            case 103:
                return R.drawable.mostly_cloudy;
            case 104:
                return R.drawable.cloudy_weather;
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
                return R.drawable.windy_weather;
            case 300:
            case 301:
                return R.drawable.rainy_day;
            case 302:
            case 303:
                return R.drawable.showcase;
            case 305:
            case 306:
            case 307:
            case 308:
                return R.drawable.rainy_weather;
            case 401:
            case 402:
            case 403:
                return R.drawable.snow_weather;
            case 407:
            case 500:
            case 501:
            case 502:
                return R.drawable.haze_weather;
            default:
                return R.drawable.unknown;
        }
    }

