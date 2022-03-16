    public boolean save() {
        if (sharedPrefs != null) {
            SharedPreferences.Editor prefEdit = sharedPrefs.edit();

            prefEdit.putBoolean("showHidden", showHidden);

            prefEdit.apply();
            return true;
        } else {
            return false;
        }
    }

