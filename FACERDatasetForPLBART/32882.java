    public static int getWeatherResourceIcon(CurrentWeatherDbHelper.WeatherRecord weatherRecord) {
        if (weatherRecord == null) {
            return R.drawable.ic_weather_set_1_31;
        }
        Weather weather = weatherRecord.getWeather();
        if ((weather.getCurrentWeathers() == null) || weather.getCurrentWeathers().isEmpty()) {
            return R.drawable.ic_weather_set_1_31;
        }
        int weatherId = weather.getCurrentWeathers().iterator().next().getWeatherId();
        boolean strongWind = weather.getWindSpeed() > 5;
        Calendar timeNow = getLocalTimeWithoutDate(weatherRecord.getLastUpdatedTime());
        Calendar sunrise = getLocalTimeWithoutDate(weather.getSunrise() * 1000);
        Calendar sunset = getLocalTimeWithoutDate(weather.getSunset() * 1000);
        boolean day = sunrise.before(timeNow) && timeNow.before(sunset);
        switch (weatherId) {
            case 800:
                if (day) {
                    if (weather.getTemperature() > 30) {
                        return R.drawable.ic_weather_set_1_36;
                    } else {
                        return R.drawable.ic_weather_set_1_32;
                    }
                } else {
                    return R.drawable.ic_weather_set_1_31;
                }
            case 801:
                if (day)
                    return R.drawable.ic_weather_set_1_34;
                else
                    return R.drawable.ic_weather_set_1_33;
            case 802:
                if (day)
                    return R.drawable.ic_weather_set_1_30;
                else
                    return R.drawable.ic_weather_set_1_29;
            case 803:
                if (day)
                    return R.drawable.ic_weather_set_1_28;
                else
                    return R.drawable.ic_weather_set_1_27;
            case 804:
                return R.drawable.ic_weather_set_1_26;
            case 300:
            case 500:
                if (day)
                    return R.drawable.ic_weather_set_1_39;
                else
                    return R.drawable.ic_weather_set_1_45;
            case 301:
            case 302:
            case 310:
            case 501:
                return R.drawable.ic_weather_set_1_11;
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
            case 502:
            case 503:
            case 504:
            case 520:
            case 521:
            case 522:
            case 531:
                return R.drawable.ic_weather_set_1_12;
            case 511:
                if (strongWind)
                    return R.drawable.ic_weather_set_1_10;
                else
                    return R.drawable.ic_weather_set_1_08;
            case 701:
                if (day)
                    return R.drawable.ic_weather_set_1_22;
                else
                    return R.drawable.ic_weather_set_1_21;
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
                return R.drawable.ic_weather_set_1_20;
            case 762:
                return R.drawable.ic_weather_set_1_na;
            case 771:
            case 781:
                return R.drawable.ic_weather_set_1_24;
            case 200:
            case 210:
            case 230:
                if (day)
                    return R.drawable.ic_weather_set_1_38;
                else
                    return R.drawable.ic_weather_set_1_45;
            case 201:
            case 202:
            case 211:
            case 212:
            case 221:
            case 231:
            case 232:
                return R.drawable.ic_weather_set_1_17;
            case 600:
                return R.drawable.ic_weather_set_1_13;
            case 601:
                if (strongWind)
                    return R.drawable.ic_weather_set_1_15;
                else
                    return R.drawable.ic_weather_set_1_14;
            case 602:
                if (strongWind)
                    return R.drawable.ic_weather_set_1_15;
                else
                    return R.drawable.ic_weather_set_1_16;
            case 611:
            case 615:
            case 620:
                return R.drawable.ic_weather_set_1_05;
            case 612:
            case 616:
            case 621:
            case 622:
                return R.drawable.ic_weather_set_1_42;
            case 900:
            case 901:
            case 902:
                return R.drawable.ic_weather_set_1_24;
            case 903:
                return R.drawable.ic_weather_set_1_na;
            case 904:
                return R.drawable.ic_weather_set_1_36;
            case 905:
                return R.drawable.ic_weather_set_1_24;
            case 906:
                return R.drawable.ic_weather_set_1_18;
            case 951:
                return R.drawable.ic_weather_set_1_26;
            case 952:
            case 953:
            case 954:
            case 955:
            case 956:
            case 957:
            case 958:
            case 959:
            case 960:
            case 961:
            case 962:
            default:
                return R.drawable.ic_weather_set_1_24;
        }
    }

