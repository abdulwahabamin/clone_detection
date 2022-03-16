    public boolean isTabletInLandscape() {
        int screenConfig = getDeviceScreenConfiguration();
        if (screenConfig==SMALL_TABLET_LANDSCAPE ||
            screenConfig==LARGE_TABLET_LANDSCAPE ||
            screenConfig==XLARGE_TABLET_LANDSCAPE)
            return true;
        else
            return false;

    }

