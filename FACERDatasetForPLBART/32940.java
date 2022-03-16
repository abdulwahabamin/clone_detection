    public String getWindDirectionByVoice() {
        if ("nothing".equals(directionTypeFromPreferences)) {
            return "";
        } else if ("deg".equals(directionTypeFromPreferences)) {
            return String.format(pressureLocale,"%.0f°", windDirection);
        } else {
            if (((windDirection >= 0) && (windDirection <= 5)) || (windDirection >= 355)) {
                return context.getString(R.string.tts_say_wind_direction_north);
            } else if ((windDirection > 5) && (windDirection < 85)) {
                return context.getString(R.string.tts_say_wind_direction_north_east);
            } else if ((windDirection >= 85) && (windDirection <= 95)) {
                return context.getString(R.string.tts_say_wind_direction_east);
            } else if ((windDirection > 95) && (windDirection < 175)) {
                return context.getString(R.string.tts_say_wind_direction_south_east);
            } else if ((windDirection >= 175) && (windDirection <= 185)) {
                return context.getString(R.string.tts_say_wind_direction_south);
            } else if ((windDirection > 185) && (windDirection < 265)) {
                return context.getString(R.string.tts_say_wind_direction_south_west);
            } else if ((windDirection >= 265) && (windDirection <= 275)) {
                return context.getString(R.string.tts_say_wind_direction_west);
            } else if ((windDirection > 275) && (windDirection < 355)) {
                return context.getString(R.string.tts_say_wind_direction_north_west);
            }
        }
        return "";
    }

