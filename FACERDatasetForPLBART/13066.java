    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view.
     *
     * @param tarray The type array
     */
    private void init(TypedArray tarray) {
        // Retrieve the mode
        this.mNavigationMode = NAVIGATION_MODE.BROWSABLE;
        int mode = tarray.getInteger(
                R.styleable.Navigable_navigation,
                NAVIGATION_MODE.BROWSABLE.ordinal());
        if (mode >= 0 && mode < NAVIGATION_MODE.values().length) {
            this.mNavigationMode = NAVIGATION_MODE.values()[mode];
        }

        // Initialize default restrictions (no restrictions)
        this.mRestrictions = new HashMap<DisplayRestrictions, Object>();

        //Initialize variables
        this.mFiles = new ArrayList<FileSystemObject>();

        // Is ChRooted environment?
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.PICKABLE) == 0) {
            // Pick mode is always ChRooted
            this.mChRooted = true;
        } else {
            this.mChRooted =
                    FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) == 0;
        }

        //Retrieve the default configuration
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
            SharedPreferences preferences = Preferences.getSharedPreferences();
            int viewMode = preferences.getInt(
                    FileManagerSettings.SETTINGS_LAYOUT_MODE.getId(),
                    ((ObjectIdentifier)FileManagerSettings.
                            SETTINGS_LAYOUT_MODE.getDefaultValue()).getId());
            changeViewMode(NavigationLayoutMode.fromId(viewMode));
        } else {
            // Pick mode has always a details layout
            changeViewMode(NavigationLayoutMode.DETAILS);
        }
    }

