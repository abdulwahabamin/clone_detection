    /**
     * setting art for artists, from artistartbykey list
     * @param item original mediaitem
     * @return mediaitem with album art
     */
    private MediaMetadataCompat setAlbumArtForArtist(MediaMetadataCompat item) {
        // we create a new object as MediaMetadataCompat is immutable
        return new MediaMetadataCompat
                .Builder(item)
                .putString(
                        MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI,
                        mArtistArtByKey.get(
                                item.getString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY)
                        )
                )
                .build();
    }

