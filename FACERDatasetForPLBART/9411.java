        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().compareTo(
                        FileManagerSettings.INTENT_SETTING_CHANGED) == 0) {

                    // The settings has changed
                    String key =
                            intent.getStringExtra(FileManagerSettings.EXTRA_SETTING_CHANGED_KEY);
                    if (key != null &&
                        key.compareTo(FileManagerSettings.SETTINGS_SHOW_TRACES.getId()) == 0) {

                        // The debug traces setting has changed. Notify to consoles
                        Console c = null;
                        try {
                            c = getBackgroundConsole();
                        } catch (Exception e) {/**NON BLOCK**/}
                        if (c != null) {
                            c.reloadTrace();
                        }
                        try {
                            c = ConsoleBuilder.getConsole(context, false);
                            if (c != null) {
                                c.reloadTrace();
                            }
                        } catch (Throwable _throw) {/**NON BLOCK**/}
                    }
                }
            }
        }

