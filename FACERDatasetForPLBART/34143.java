    public static String getBeaufortName(int wind, Context context) {
        if (wind == 0) {
            return context.getString(R.string.beaufort_calm);
        } else if (wind == 1) {
            return context.getString(R.string.beaufort_light_air);
        } else if (wind == 2) {
            return context.getString(R.string.beaufort_light_breeze);
        } else if (wind == 3) {
            return context.getString(R.string.beaufort_gentle_breeze);
        } else if (wind == 4) {
            return context.getString(R.string.beaufort_moderate_breeze);
        } else if (wind == 5) {
            return context.getString(R.string.beaufort_fresh_breeze);
        } else if (wind == 6) {
            return context.getString(R.string.beaufort_strong_breeze);
        } else if (wind == 7) {
            return context.getString(R.string.beaufort_high_wind);
        } else if (wind == 8) {
            return context.getString(R.string.beaufort_gale);
        } else if (wind == 9) {
            return context.getString(R.string.beaufort_strong_gale);
        } else if (wind == 10) {
            return context.getString(R.string.beaufort_storm);
        } else if (wind == 11) {
            return context.getString(R.string.beaufort_violent_storm);
        } else {
            return context.getString(R.string.beaufort_hurricane);
        }
    }

