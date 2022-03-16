    public static void resetMusicStats(Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        realm.where(Artist.class).findAll().clear();
        realm.where(Album.class).findAll().clear();
        realm.where(Song.class).findAll().clear();
        realm.where(Playlist.class).findAll().clear();
        realm.commitTransaction();
        realm.close();
    }

