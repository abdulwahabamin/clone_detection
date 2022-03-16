    public static String getPressureUnit(Context context) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_PRESSURE_UNITS, "hpa");
        switch (unitsFromPreferences) {
            case "mmhg": return context.getString(R.string.pressure_measurement_mmhg);
            case "inhg": return context.getString(R.string.pressure_measurement_inhg);
            case "mbar": return context.getString(R.string.pressure_measurement_mbar);
            case "psi": return context.getString(R.string.pressure_measurement_psi);
            default: return context.getString(R.string.pressure_measurement);
        }
    }

