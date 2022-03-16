    /**
     * Returns the correct background color for the GridView based on the selected theme.
     * Do not use this method if the GridView needs cards as its background.
     */
    public static int getGridViewBackground(Context context) {
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            return 0xFF131313;
        } else {
            return 0xFFFFFFFF;
        }

    }

