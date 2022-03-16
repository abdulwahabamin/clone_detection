    private static void createSongEntry(Context context, String songPath) {
        RhythmSong songEntry = getSongMeta(songPath);

        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Artist artistRecord = getOrCreateArtist(realm, songEntry);
        Album albumRecord = getOrCreateAlbum(realm, artistRecord, songEntry);
        getOrCreateSong(realm, albumRecord, songEntry.getTrackTitle(), songEntry.getDuration(), songPath);
        realm.commitTransaction();
        realm.close();
    }

