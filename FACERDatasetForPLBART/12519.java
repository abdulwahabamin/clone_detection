    /**
     * Method that removes the configuration listener.
     *
     * @param listener The configuration listener to be removed
     */
    public static void removeConfigurationListener(ConfigurationListener listener) {
        CONFIGURATION_LISTENERS.remove(listener);
    }

