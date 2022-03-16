    public MusicMetaData(String filePath) {
        MediaMetadataRetriever metaRetriver = new MediaMetadataRetriever();

        try {
            metaRetriver.setDataSource(filePath);

            this.artist = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            this.album = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            this.title = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            this.albumArt = metaRetriver.getEmbeddedPicture();
            try {
                this.duration = Long.valueOf(metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
            } catch (Exception e) {
                Timber.e(e, "setDataSource - duration");
                this.duration = 0L;
            }
            metaRetriver.release();
        } catch (Exception e) {
            Timber.e(e, "setDataSource - " + filePath);
            this.artist = "Unknown Artist";
            this.album = "Unknown Album";
            this.title = filePath;
            this.albumArt = null;
            this.duration = 0L;
            metaRetriver.release();
        }

    }

