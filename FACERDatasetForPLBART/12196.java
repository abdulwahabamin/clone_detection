    /**
     * Method that initializes the application.
     */
    private void init() {
        //Save the static application reference
        sApp = this;

        // Read the system properties
        sSystemProperties = new Properties();
        readSystemProperties();

        // Check if the application is debuggable
        sIsDebuggable = (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));

        // Check if the device has shell commands and if is rooted
        sHasShellCommands = areShellCommandsPresent();
        sIsDeviceRooted = isRootPresent();

        // Check optional commands
        loadOptionalCommands();

        //Sets the default preferences if no value is set yet
        Preferences.loadDefaults();

        // Read AIDs
        AIDHelper.getAIDs(getApplicationContext(), true);

        // Allocate the default and current themes
        String defaultValue = ((String)FileManagerSettings.
                SETTINGS_THEME.getDefaultValue());
        String value = Preferences.getSharedPreferences().getString(
                FileManagerSettings.SETTINGS_THEME.getId(),
                defaultValue);
        ThemeManager.getDefaultTheme(getApplicationContext());
        if (!ThemeManager.setCurrentTheme(getApplicationContext(), value)) {
            //The current theme was not found. Mark the default setting as default theme
            ThemeManager.setCurrentTheme(getApplicationContext(), defaultValue);
            try {
                Preferences.savePreference(
                        FileManagerSettings.SETTINGS_THEME, defaultValue, true);
            } catch (Throwable ex) {
                Log.w(TAG, "can't save theme preference", ex); //$NON-NLS-1$
            }
        }
        // Set the base theme
        Theme theme = ThemeManager.getCurrentTheme(getApplicationContext());
        theme.setBaseTheme(getApplicationContext(), false);

        //Create a console for background tasks. Register the virtual console prior to
        // the real console so mount point can be listed properly
        VirtualMountPointConsole.registerVirtualConsoles(getApplicationContext());
        allocBackgroundConsole(getApplicationContext());

        //Force the load of mime types
        try {
            MimeTypeHelper.loadMimeTypes(getApplicationContext());
        } catch (Exception e) {
            Log.e(TAG, "Mime-types failed.", e); //$NON-NLS-1$
        }
    }

