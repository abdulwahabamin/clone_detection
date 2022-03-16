    private static Album getOrCreateAlbum(Realm realm, Artist artistRecord, RhythmSong rhythmSong) {
        Album albumRecord = null;
        if (rhythmSong.getAlbumTitle() == null) {
            for (Album albumItem : artistRecord.getAlbums()) {
                if (albumItem.getAlbumTitle().equals("Untitled Album")) {
                    albumRecord = albumItem;
                }
            }
            if (albumRecord != null) {
                return albumRecord;
            } else {
                albumRecord = realm.createObject(Album.class);
                albumRecord.setAlbumTitle("Untitled Album");
                albumRecord.setId(UUID.randomUUID().toString());
                albumRecord.setArtistId(artistRecord.getId());
                if (rhythmSong.getImageData() != null) {
                    albumRecord.setCoverPath(rhythmSong.getSongLocation());
                }
                artistRecord.getAlbums().add(albumRecord);
                return albumRecord;
            }
        } else {
            for (Album albumItem : artistRecord.getAlbums()) {
                if (albumItem.getAlbumTitle().equals(rhythmSong.getAlbumTitle())) {
                    albumRecord = albumItem;
                }
            }
            if (albumRecord != null) {
                return albumRecord;
            } else {
                albumRecord = realm.createObject(Album.class);
                albumRecord.setAlbumTitle(rhythmSong.getAlbumTitle());
                albumRecord.setId(UUID.randomUUID().toString());
                albumRecord.setArtistId(artistRecord.getId());
                if (rhythmSong.getImageData() != null) {
                    albumRecord.setCoverPath(rhythmSong.getSongLocation());
                }
                artistRecord.getAlbums().add(albumRecord);
                return albumRecord;
            }
        }
    }

