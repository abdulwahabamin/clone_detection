    /**
     * Returns the correct empty color patch drawable based on the selected theme.
     */
    public static int getEmptyColorPatch(Context context) {
        mApp = (Common) context.getApplicationContext();

        int resourceID = 0;
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            resourceID = context.getResources().getIdentifier("empty_color_patch", "drawable", context.getPackageName());
        } else {
            resourceID = context.getResources().getIdentifier("empty_color_patch_light", "drawable", context.getPackageName());
        }

        return resourceID;
    }

