    public boolean load() {
        if (sharedPrefs != null) {
            showHidden = sharedPrefs.getBoolean("showHidden", false);
            return true;
        } else {
            return false;
        }
    }

