    public static <T extends RealmObject> void saveData(Collection<T> data)
    {
        getRealm().beginTransaction();
        getRealm().insertOrUpdate(data);
        getRealm().commitTransaction();
    }

