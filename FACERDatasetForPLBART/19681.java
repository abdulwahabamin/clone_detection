    public String getString(String key) throws SecurePreferencesException {
        if (preferences.contains(toKey(key))) {
                String securedEncodedValue = preferences.getString(toKey(key), "");
                return decrypt(securedEncodedValue);
        }
        return null;
    }

