    public static Song getSongById(String id, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Song song = realm.where(Song.class)
                .contains("id", id)
                .findFirst();
        realm.commitTransaction();
        realm.close();
        return song;
    }

