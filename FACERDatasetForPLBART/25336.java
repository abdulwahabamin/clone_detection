    private static Album getAlbumById(String id, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Album album = realm.where(Album.class)
                .contains("id", id)
                .findFirst();
        realm.commitTransaction();
        realm.close();
        return album;
    }

