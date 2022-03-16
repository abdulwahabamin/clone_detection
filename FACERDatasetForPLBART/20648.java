    /**
     * Sets the indicator colors, when QuickScroll.TYPE_INDICATOR is selected as type.
     * <p/>
     *
     * @param background the background color of the square
     * @param tip        the background color of the tip triangle
     * @param text       the color of the text
     */
    public void setIndicatorColor(final int background, final int tip, final int text) {
        if (type == TYPE_INDICATOR || type == TYPE_INDICATOR_WITH_HANDLE) {
            ((Pin) scrollIndicator.findViewById(ID_PIN)).setColor(tip);
            scrollIndicatorTextView.setTextColor(text);
            scrollIndicatorTextView.setBackgroundColor(background);
        }
    }

