    /**
     * Sets the color of the picker and saves it to the {@link SharedPreferences}.
     *
     * @param color The new color.
     */
    public void setColor(int color) {
        // Always persist/notify the first time; don't assume the field's default of false.
        final boolean changed = this.mColor != color;
        if (changed) {
            this.mColor = color;
            // when called from onSetInitialValue the view is still not set
            if (this.mColorPicker != null) {
                this.mColorPicker.setColor(color);
            }
            persistInt(color);
            if (changed) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

