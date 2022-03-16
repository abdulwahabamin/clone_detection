    /**
     * Obtains code for user-chosen device locale.
     *
     * @param locale system locale
     * @return ISO-defined language and (optionally) country codes
     */
    private String getSystemLocaleCode(Locale locale) {
        return locale.getLanguage() + "-r" + locale.getCountry();
    }

