    /**
     * Method that refreshes the Icons layout mode.
     * This is currently called for refreshing Icons layout mode when switching between portrait
     * and landscape. Other layout modes don't need to be refreshed due to list view display
     */
    public void refreshViewMode() {
        if (this.mCurrentMode.compareTo(NavigationLayoutMode.ICONS) == 0) {
            this.mCurrentMode = null;
            changeViewMode(NavigationLayoutMode.ICONS);
        }
    }

