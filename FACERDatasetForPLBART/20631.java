    /**
     * Sets the popup colors, when QuickScroll.TYPE_POPUP is selected as type.
     * <p/>
     *
     * @param backgroundcolor the background color of the TextView
     * @param bordercolor     the background color of the border surrounding the TextView
     * @param textcolor       the color of the text
     */
    public void setPopupColor(final int backgroundcolor, final int bordercolor, final int borderwidthDPI, final int textcolor, float cornerradiusDPI) {

        final GradientDrawable popupbackground = new GradientDrawable();
        popupbackground.setCornerRadius(cornerradiusDPI * getResources().getDisplayMetrics().density);
        popupbackground.setStroke((int) (borderwidthDPI * getResources().getDisplayMetrics().density), bordercolor);
        popupbackground.setColor(backgroundcolor);

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
            scrollIndicatorTextView.setBackgroundDrawable(popupbackground);
        else
            scrollIndicatorTextView.setBackground(popupbackground);

        scrollIndicatorTextView.setTextColor(textcolor);
    }

