    public static Realm getRealm(Context ctx) {
        if (realmInstance==null)
        {
            realmInstance=new RealmHelper(ctx);
        }
        return realm;
    }

