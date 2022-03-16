    public boolean isPhoneInPortrait() {
        int screenConfig = getDeviceScreenConfiguration();
        if (screenConfig==REGULAR_SCREEN_PORTRAIT)
            return true;
        else
            return false;
    }

