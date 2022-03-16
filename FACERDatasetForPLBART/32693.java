    public static int getPressureDecimalPlaces(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_PRESSURE_UNITS, "hpa");
        switch (unitsFromPreferences) {
            case "mmhg": return 2;
            case "inhg": return 2;
            case "mbar": return 0;
            case "psi" : return 2;
            default: return 0;
        }
    }

