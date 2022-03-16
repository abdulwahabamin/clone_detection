    @Provides
    @Singleton
    AppDataManager getAppDataManager(ApiHelper apiHelper, PrefsHelper prefsHelper,
                                     LocalStorageHelper localStorageHelper, DbHelper dbHelper) {
        return new AppDataManager(apiHelper, prefsHelper, localStorageHelper, dbHelper);
    }

