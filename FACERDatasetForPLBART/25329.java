    private static void getOrCreateSong(Realm realm, Album albumRecord, String songTitle, long duration, String songPath) {
        Song songRecord = null;
        for (Song songItem : albumRecord.getSongs()) {
            if (songItem.getSongLocation().equals(songPath)) {
                songRecord = songItem;
            }
        }
        if (songRecord == null) {
            songRecord = realm.createObject(Song.class);
            songRecord.setId(UUID.randomUUID().toString());
            songRecord.setSongTitle(songTitle != null ? songTitle : "Untitled Song");
            songRecord.setAlbumId(albumRecord.getId());
            songRecord.setSongLocation(songPath);
            if (duration > 0) {
                songRecord.setSongDuration(duration);
            }
            albumRecord.getSongs().add(songRecord);
        }

    }

