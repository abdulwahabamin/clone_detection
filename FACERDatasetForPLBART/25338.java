    private static Playlist getPlaylistById(String id, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Playlist playlist = realm.where(Playlist.class)
                .contains("id", id)
                .findFirst();
        realm.commitTransaction();
        realm.close();
        return playlist;
    }

