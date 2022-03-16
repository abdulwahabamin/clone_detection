    private static void loadAlbumArtFromDiskWithLastfmFallback(final long albumId, ImageView view,
                                                               final ImageLoadingListener listener) {
        ImageLoader.getInstance()
                .displayImage(TimberUtils.getAlbumArtUri(albumId).toString(),
                        view,
                        diskDisplayImageOptions,
                        new SimpleImageLoadingListener() {
                            @Override
                            public void onLoadingFailed(String imageUri, View view,
                                                        FailReason failReason) {
                                loadAlbumArtFromLastfm(albumId, (ImageView) view, listener);
                                listener.onLoadingFailed(imageUri, view, failReason);
                            }

                            @Override
                            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                listener.onLoadingComplete(imageUri, view, loadedImage);
                            }
                        });
    }

