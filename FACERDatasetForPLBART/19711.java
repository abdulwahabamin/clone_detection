    public boolean isPhoneInLandscape() {
        int screenConfig = getDeviceScreenConfiguration();
        if (screenConfig==REGULAR_SCREEN_LANDSCAPE)
            return true;
        else
            return false;
    }

