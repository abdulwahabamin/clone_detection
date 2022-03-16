    /**
     * Method that set a color scheme (use setting or theme default)
     *
     * @param color The color reference
     * @param colorScheme The array of colors
     * @param pos The position of the color
     * @hide
     */
    void setColorScheme(HighlightColors color, int[] colorScheme, int pos) {
        try {
            this.mColorScheme[pos].setColor(colorScheme[pos]);
        } catch (Exception e) {
            this.mColorScheme[pos].setColor(
                    ThemeManager.getCurrentTheme(
                            getActivity()).getColor(getActivity(), color.getResId()));
            Log.w(TAG,
                    String.format(
                            "Color scheme value not found for \"%s\"", //$NON-NLS-1$
                            color.getId()));
        }
    }

