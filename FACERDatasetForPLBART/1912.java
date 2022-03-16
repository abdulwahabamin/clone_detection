    public static RealmHelper getRealmInstance(Context ctx)
    {
        if (realmInstance==null)
        {
            realmInstance=new RealmHelper(ctx);
        }
        return realmInstance;
    }

