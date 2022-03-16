    /**
     * setting album art for a song according to its album key
     * @param item old mediametadata
     * @return new mediametadata with the album art
     */
    private MediaMetadataCompat setAlbumArt(MediaMetadataCompat item) {
        // we create a new object as MediaMetadataCompat is immutable
        return new MediaMetadataCompat
                .Builder(item)
                .putString(
                        MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI,
                        mAlbumListByKey.get(
                                item.getString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY)
                        ).getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI)
                )
                .build();
    }

