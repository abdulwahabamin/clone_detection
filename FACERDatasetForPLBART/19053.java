    /**
     * Returns a solid background color based on the selected theme.
     */
    public static int getBackgroundColor(Context context) {
        mApp = (Common) context.getApplicationContext();

        int color;
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            color = 0xFF111111;
        } else {
            color = 0xFFDDDDDD;
        }

        return color;
    }

