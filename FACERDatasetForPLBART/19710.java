    public boolean isTabletInPortrait() {
        int screenConfig = getDeviceScreenConfiguration();
        if (screenConfig==SMALL_TABLET_PORTRAIT ||
            screenConfig==LARGE_TABLET_PORTRAIT ||
            screenConfig==XLARGE_TABLET_PORTRAIT)
            return true;
        else
            return false;

    }

