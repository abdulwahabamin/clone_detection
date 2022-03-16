    private void setUpArtistDetails() {

        final Artist artist = ArtistLoader.getArtist(getActivity(), artistID);
        List<Song> songList = ArtistSongLoader.getSongsForArtist(getActivity(), artistID);
        mAdapter = new ArtistSongAdapter(getActivity(), songList, artistID);

        collapsingToolbarLayout.setTitle(artist.name);

        LastFmClient.getInstance(getActivity()).getArtistInfo(new ArtistQuery(artist.name), new ArtistInfoListener() {
            @Override
            public void artistInfoSucess(final LastfmArtist artist) {
                if (artist != null) {

                    ImageLoader.getInstance().displayImage(artist.mArtwork.get(4).mUrl, artistArt,
                            new DisplayImageOptions.Builder().cacheInMemory(true)
                                    .cacheOnDisk(true)
                                    .showImageOnFail(R.drawable.ic_empty_music2)
                                    .build(), new SimpleImageLoadingListener() {
                                @Override
                                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                    largeImageLoaded = true;
                                    try {
                                        new Palette.Builder(loadedImage).generate(new Palette.PaletteAsyncListener() {
                                            @Override
                                            public void onGenerated(Palette palette) {
                                                Palette.Swatch swatch = palette.getVibrantSwatch();
                                                if (swatch != null) {
                                                    primaryColor = swatch.getRgb();
                                                    collapsingToolbarLayout.setContentScrimColor(primaryColor);
                                                    if (getActivity() != null)
                                                        ATEUtils.setStatusBarColor(getActivity(), Helpers.getATEKey(getActivity()), primaryColor);
                                                } else {
                                                    Palette.Swatch swatchMuted = palette.getMutedSwatch();
                                                    if (swatchMuted != null) {
                                                        primaryColor = swatchMuted.getRgb();
                                                        collapsingToolbarLayout.setContentScrimColor(primaryColor);
                                                        if (getActivity() != null)
                                                            ATEUtils.setStatusBarColor(getActivity(), Helpers.getATEKey(getActivity()), primaryColor);
                                                    }
                                                }

                                            }
                                        });
                                    } catch (Exception ignored) {

                                    }
                                }
                            });
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setBlurredPlaceholder(artist);
                        }
                    }, 100);

                }
            }

            @Override
            public void artistInfoFailed() {

            }
        });

    }

