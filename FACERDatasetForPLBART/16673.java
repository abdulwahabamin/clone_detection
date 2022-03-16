    public void updateMetadata() {
        MediaSessionCompat.QueueItem currentMusic = getCurrentMusic();
        if (currentMusic == null || currentMusic.getDescription() == null
                || currentMusic.getDescription().getMediaId() == null) {
            metadataUpdateListener.onMetadataRetrieveError();
            return;
        }
        final String musicId = MediaIDHelper.extractMusicIDFromMediaID(currentMusic.getDescription().getMediaId());
        MediaMetadataCompat metadata = musicProvider.getMusic(musicId);
        if (metadata == null) {
            throw new IllegalArgumentException("Invalid musicId " + musicId);
        }

        metadataUpdateListener.onMetadataChanged(metadata);

        // Set the proper album artwork on the media session, so it can be shown in the
        // locked screen and in other places.
//        if (metadata.getDescription().getIconBitmap() == null &&
//                metadata.getDescription().getIconUri() != null) {
//            final String albumUri = metadata.getDescription().getIconUri().toString();
//            Glide.with(FireApplication.getInstance())
//                    .load(albumUri)
//                    .asBitmap()
//                    .into(new SimpleTarget<Bitmap>(200, 200) {
//                        @Override
//                        public void onResourceReady(final Bitmap resource, GlideAnimation glideAnimation) {
//                            musicProvider.updateMusicArt(musicId, resource, resource);
//
//                            // If we are still playing the same music, notify the listeners:
//                            MediaSessionCompat.QueueItem currentMusic = getCurrentMusic();
//                            if (currentMusic == null) {
//                                return;
//                            }
//                            String currentPlayingId = MediaIDHelper.extractMusicIDFromMediaID(
//                                    currentMusic.getDescription().getMediaId());
//                            if (musicId.equals(currentPlayingId)) {
//                                metadataUpdateListener.onMetadataChanged(musicProvider.getMusic(currentPlayingId));
//                            }
//
//                        }
//                    });
//
//        }
    }

