    RealmHelper(Context ctx)
    {
        Realm.init(ctx);
        RealmConfiguration config = getRealmConfig();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

