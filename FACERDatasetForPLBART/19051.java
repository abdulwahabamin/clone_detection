    /**
     * Returns the resource id of the shadowed circle drawable based on the selected theme.
     */
    public static int getShadowedCircle(Context context) {

        int resourceID = context.getResources().getIdentifier("shadowed_circle_red", "drawable", context.getPackageName());
        if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(BLUE)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_blue", "drawable", context.getPackageName());
        } else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(RED)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_red", "drawable", context.getPackageName());
        } else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(GREEN)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_green", "drawable", context.getPackageName());
        } else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(ORANGE)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_orange", "drawable", context.getPackageName());
        } else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(PURPLE)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_purple", "drawable", context.getPackageName());
        } else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(MAGENTA)) {
            resourceID = context.getResources().getIdentifier("shadowed_circle_magenta", "drawable", context.getPackageName());
        }

        return resourceID;
    }

