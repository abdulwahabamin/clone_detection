    public static <E> void deleteAll(RealmQuery query)
    {
        getRealm().beginTransaction();
        query.findAll().deleteAllFromRealm();
        getRealm().commitTransaction();
    }

