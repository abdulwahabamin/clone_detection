    /**
     * Method that returns a system property value
     *
     * @param property The system property key
     * @return String The system property value
     */
    public static String getSystemProperty(String property) {
        return sSystemProperties.getProperty(property);
    }

