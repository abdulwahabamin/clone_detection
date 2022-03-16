    public static boolean isWeatherDescriptionWithSnow(int weatherId) {
        if ((weatherId >= 600) && (weatherId < 700)) {
            return true;
        } else {
            return false;
        }
    }

