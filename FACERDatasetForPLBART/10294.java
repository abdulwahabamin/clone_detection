    /**
     * Method that sets if the view should use flinger gesture detection.
     *
     * @param useFlinger If the view should use flinger gesture detection
     */
    public void setUseFlinger(boolean useFlinger) {
        if (this.mCurrentMode.compareTo(NavigationLayoutMode.ICONS) == 0) {
            // Not supported
            return;
        }
        // Set the flinger listener (only when navigate)
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
            if (this.mAdapterView instanceof FlingerListView) {
                if (useFlinger) {
                    ((FlingerListView)this.mAdapterView).
                    setOnItemFlingerListener(this.mOnItemFlingerListener);
                } else {
                    ((FlingerListView)this.mAdapterView).setOnItemFlingerListener(null);
                }
            }
        }
    }

