    /**
     * Method that should be invoked when the theme of the app was changed
     */
    public void notifyThemeChanged() {
        // Empty icon holder
        if (this.mIconHolder != null) {
            this.mIconHolder.cleanup();
        }
        final boolean displayThumbs = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_DISPLAY_THUMBS.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_DISPLAY_THUMBS.getDefaultValue()).booleanValue());
        this.mIconHolder = new IconHolder(getContext(), displayThumbs);
        loadDefaultIcons();
    }

