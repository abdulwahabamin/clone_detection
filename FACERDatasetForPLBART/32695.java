    public static PressureWithUnit getPressureWithUnit(Context context, double value, Locale locale) {
        String unitsFromPreferences = PreferenceManager.getDefaultSharedPreferences(context).getString(
                Constants.KEY_PREF_PRESSURE_UNITS, "hpa");
        switch (unitsFromPreferences) {
            case "mmhg": return new PressureWithUnit(value * 0.75f,
                                                 context.getString(R.string.pressure_measurement_mmhg), locale);
            case "inhg": return new PressureWithUnit(value * 0.029529983071445f,
                                                 context.getString(R.string.pressure_measurement_inhg), locale);
            case "mbar": return new PressureWithUnit(value,
                                                 context.getString(R.string.pressure_measurement_mbar), locale);
            case "psi": return new PressureWithUnit(value * 0.0145037738f,
                                                 context.getString(R.string.pressure_measurement_psi), locale);
            default: return new PressureWithUnit(value, context.getString(R.string.pressure_measurement), locale);
        }
    }

