    /**
     * 根�?�得到的天气type，返回对应的天气图片Id
     *
     * @author �?�?宇 2016-7-30 下�?�8:26:35
     */
    public static int selectImage(String type) {
        int icId;
        switch (type) {
            case "阴":
                icId = R.mipmap.weather_cloudy_day;
                break;
            case "多云":
                icId = R.mipmap.weather_cloudy_weather;
                break;
            case "雾":
                icId = R.mipmap.weather_fog;
                break;
            case "霾":
                icId = R.mipmap.weather_haze;
                break;
            case "大雨":
                icId = R.mipmap.weather_rain_heavy;
                break;
            case "�?雨":
                icId = R.mipmap.weather_rain_light;
                break;
            case "中雨":
                icId = R.mipmap.weather_rain_moderate;
                break;
            case "�?到中雨":
                icId = R.mipmap.weather_rain_light_moderate;
                break;
            case "中到大雨":
                icId = R.mipmap.weather_rain_moderate_heavy;
                break;
            case "阵雨":
                icId = R.mipmap.weather_rain_shower;
                break;
            case "雷阵雨":
                icId = R.mipmap.weather_rain_thunderstorms;
                break;
            case "暴雨":
                icId = R.mipmap.weather_rain_torrential;
                break;
            case "雨夹雪":
                icId = R.mipmap.weather_sleet;
                break;
            case "大雪":
                icId = R.mipmap.weather_snow_heavy;
                break;
            case "�?雪":
                icId = R.mipmap.weather_snow_light;
                break;
            case "中雪":
                icId = R.mipmap.weather_snow_moderate;
                break;
            case "阵雪":
                icId = R.mipmap.weather_snow_shower;
                break;
            case "暴雪":
                icId = R.mipmap.weather_snow_torrential;
                break;
            case "晴":
                icId = R.mipmap.weather_sunny_day;
                break;
            default:
                icId = R.mipmap.not_applicable;
                break;
        }
        return icId;
    }

