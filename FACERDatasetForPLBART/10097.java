    /**
     * Method that returns the current theme
     *
     * @param ctx The current context
     * @return Theme The current theme
     */
    public static synchronized Theme getCurrentTheme(Context ctx) {
        if (mCurrentTheme == null) {
            // Use the default theme
            mCurrentTheme = getDefaultTheme(ctx);
        }
        return mCurrentTheme;
    }

