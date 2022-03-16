    /**
     * Method that register the application context.
     */
    private void register() {
        // Register the notify broadcast receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(FileManagerSettings.INTENT_SETTING_CHANGED);
        registerReceiver(this.mNotificationReceiver, filter);

        // Register the uninstall broadcast receiver
        IntentFilter unfilter = new IntentFilter();
        unfilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        unfilter.addAction(Intent.ACTION_PACKAGE_FULLY_REMOVED);
        unfilter.addDataScheme("package"); //$NON-NLS-1$
        registerReceiver(this.mUninstallReceiver, unfilter);
    }

