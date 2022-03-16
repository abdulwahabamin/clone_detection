    public void onCreate() {
        super.onCreate();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        CrashlyticsCore core = new CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build();
        Fabric.with(this, new Crashlytics.Builder().core(core).build());

        OneSignal.startInit(this).init();
        if (BuildConfig.DEV_MODE) {
            LeakCanary.install(this);
            Stetho.initializeWithDefaults(this);
            Timber.plant(new Timber.DebugTree());
            OneSignal.sendTag("is_test", "true");
        } else {
            Timber.plant(new CrashlyticsTree());
            OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
                @Override
                public void idsAvailable(String usernameID, String registrationId) {
                    Crashlytics.setString("usernameID", usernameID);
                    Crashlytics.setString("registrationId", registrationId);
                }
            });
        }
    }

