    public static void ensureStartups(Context context) {
        HomeFarm.init(context);
        Files.setAppHomePath(context);
        SettingsDb.init();
        State.setSettings(SettingsDb.getSettings());
        Device.init(context);
    }

