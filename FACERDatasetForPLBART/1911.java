    public static RealmConfiguration getRealmConfig()
    {
        return new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }

