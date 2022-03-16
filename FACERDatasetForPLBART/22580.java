    private static void loadAlbumArtFromLastfm(long albumId, final ImageView albumArt, final ImageLoadingListener listener) {
        Album album = AlbumLoader.getAlbum(albumArt.getContext(), albumId);
        LastFmClient.getInstance(albumArt.getContext())
                .getAlbumInfo(new AlbumQuery(album.title, album.artistName),
                        new AlbumInfoListener() {
                            @Override
                            public void albumInfoSuccess(final LastfmAlbum album) {
                                if (album != null) {
                                    ImageLoader.getInstance()
                                            .displayImage(album.mArtwork.get(4).mUrl,
                                                    albumArt,
                                                    lastfmDisplayImageOptions, new SimpleImageLoadingListener() {
                                                        @Override
                                                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                                            listener.onLoadingComplete(imageUri, view, loadedImage);
                                                        }

                                                        @Override
                                                        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                                                            listener.onLoadingFailed(imageUri, view, failReason);
                                                        }
                                                    });
                                }
                            }

                            @Override
                            public void albumInfoFailed() {
                            }
                        });
    }

