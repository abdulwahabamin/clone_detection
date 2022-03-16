    public static void updateSongCount(String songId, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Song song = realm.where(Song.class)
                .contains("id", songId)
                .findFirst();
        song.setNoOfPlayed(song.getNoOfPlayed() + 1);
        song.setLastPlayed(System.currentTimeMillis());

        realm.commitTransaction();
        realm.close();
    }

