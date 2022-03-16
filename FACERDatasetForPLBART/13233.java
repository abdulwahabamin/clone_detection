    /**
     * Method that returns if the device is a tablet
     *
     * @param ctx The current context
     * @return boolean If device is a table
     */
    public static boolean isTablet(Context ctx) {
        Configuration configuration = ctx.getResources().getConfiguration();
        return (configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

