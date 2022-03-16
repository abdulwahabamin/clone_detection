    /**
     * @param value The value to get the enum label for.
     * @return Returns the label that belongs to the given value. Fallback value is CLOUDS.
     */
    public static WeatherCategories getLabelForValue(int value) {
        switch (value) {
            case 10:
                return WeatherCategories.CLEAR_SKY;
            case 20:
                return WeatherCategories.CLOUDS;
            case 30:
                return WeatherCategories.SCATTERED_CLOUDS;
            case 40:
                return WeatherCategories.BROKEN_CLOUDS;
            case 50:
                return WeatherCategories.MIST;
            case 60:
                return WeatherCategories.SHOWER_RAIN;
            case 70:
                return WeatherCategories.RAIN;
            case 80:
                return WeatherCategories.SNOW;
            case 90:
                return WeatherCategories.THUNDERSTORM;
            default:
                return WeatherCategories.CLOUDS;
        }
    }

