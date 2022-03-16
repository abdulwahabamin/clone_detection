    public static <T extends RealmObject> void saveData(T data)
    {
        getRealm().beginTransaction();
        getRealm().insertOrUpdate(data);
        getRealm().commitTransaction();
    }

