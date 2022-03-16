    public static double convertWind(double wind, SharedPreferences sp) {
        if (sp.getString("speedUnit", "m/s").equals("kph")) {
            return wind * 3.6;
        }
        else if (sp.getString("speedUnit", "m/s").equals("mph")) {
            return wind * 2.23693629205;
        }
        else if (sp.getString("speedUnit", "m/s").equals("kn")) {
            return wind * 1.943844;
        }
        else if (sp.getString("speedUnit", "m/s").equals("bft")) {
            if(wind < 0.3) {
                return 0; // Calm
            }
            else if (wind < 1.5) {
                return 1; // Light air
            }
            else if (wind < 3.3) {
                return 2; // Light breeze
            }
            else if (wind < 5.5) {
                return 3; // Gentle breeze
            }
            else if (wind < 7.9) {
                return 4; // Moderate breeze
            }
            else if (wind < 10.7) {
                return 5; // Fresh breeze
            }
            else if (wind < 13.8) {
                return 6; // Strong breeze
            }
            else if (wind < 17.1) {
                return 7; // High wind
            }
            else if (wind < 20.7) {
                return 8; // Gale
            }
            else if (wind < 24.4) {
                return 9; // Strong gale
            }
            else if (wind < 28.4) {
                return 10; // Storm
            }
            else if (wind < 32.6) {
                return 11; // Violent storm
            }
            else {
                return 12; // Hurricane
            }
        }
        else {
            return wind;
        }
    }

