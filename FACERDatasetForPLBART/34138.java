    public static float convertRain(float rain, SharedPreferences sp) {
        if (sp.getString("lengthUnit", "mm").equals("mm")) {
            return rain;
        } else {
            return rain / 25.4f;
        }
    }

