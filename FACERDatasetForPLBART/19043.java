    /**
     * Returns the correct background for the GridView card based on the selected theme.
     */
    public static int getGridViewCardBackground(Context context) {
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            return context.getResources().getIdentifier("card_gridview_dark", "drawable", context.getPackageName());
        } else {
            return context.getResources().getIdentifier("card_gridview_light", "drawable", context.getPackageName());
        }

    }

