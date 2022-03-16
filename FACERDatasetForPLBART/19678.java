    public void put(String key, String value) {
        if (value == null) {
                preferences.edit().remove(toKey(key)).commit();
        }
        else {
                putValue(toKey(key), value);
        }
    }

