    private void checkKey(String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getString(key, "").equals("")){
            sp.edit().remove(key).apply();
        }
    }

