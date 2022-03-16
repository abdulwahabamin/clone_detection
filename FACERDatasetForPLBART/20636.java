    /**
     * Set the colors of the handlebar.
     *
     * @param inactive     - color of the inactive handlebar
     * @param activebase   - base color of the active handlebar
     * @param activestroke - stroke of the active handlebar
     */
    public void setHandlebarColor(final int inactive, final int activebase, final int activestroke) {
        if (type == TYPE_INDICATOR_WITH_HANDLE || type == TYPE_POPUP_WITH_HANDLE) {
            final float density = getResources().getDisplayMetrics().density;
            final GradientDrawable bg_inactive = new GradientDrawable();
            bg_inactive.setCornerRadius(density);
            bg_inactive.setColor(inactive);
            bg_inactive.setStroke((int) (5 * density), Color.TRANSPARENT);
            final GradientDrawable bg_active = new GradientDrawable();
            bg_active.setCornerRadius(density);
            bg_active.setColor(activebase);
            bg_active.setStroke((int) (5 * density), activestroke);
            final StateListDrawable states = new StateListDrawable();
            states.addState(new int[]{android.R.attr.state_selected}, bg_active);
            states.addState(new int[]{android.R.attr.state_enabled}, bg_inactive);

            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                handleBar.setBackgroundDrawable(states);
            else
                handleBar.setBackground(states);
        }
    }

