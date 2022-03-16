    public static boolean sunny(String weather) {
        for (String weatherKey : SUNNY) {
            if (weatherKey.contains(weather) || weather.contains(weatherKey)) {
                return true;
            }
        }
        return false;
    }

