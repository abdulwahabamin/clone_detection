    @Override
    public void displaySong(String songTitle,
                            String songSubtitle,
                            String songDuration,
                            String albumArtPath) {
        songTitleMainTv.setText(songTitle);
        songArtistMainTv.setText(songSubtitle);

        Glide.with(getActivity()).clear(albumArtIv);

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        if (albumArtPath != null) {
            Glide.with(getActivity())
                    .asBitmap()
                    .load(albumArtPath)
                    .apply(options)
                    .listener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e,
                                                    Object model,
                                                    Target<Bitmap> target,
                                                    boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource,
                                                       Object model,
                                                       Target<Bitmap> target,
                                                       DataSource dataSource,
                                                       boolean isFirstResource) {

                            updateUiColor(resource);
                            return false;
                        }
                    })
                    .transition(BitmapTransitionOptions.withCrossFade())
                    .into(albumArtIv);

            Glide.with(getActivity())
                    .load(albumArtPath)
                    .apply(options)
                    .into(smallAlbumArtIv);
        } else {
            Glide.with(getActivity()).clear(albumArtIv);
            Glide.with(getActivity()).clear(smallAlbumArtIv);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                albumArtIv.setImageDrawable(getActivity()
                        .getDrawable(R.drawable.default_song_art));
                smallAlbumArtIv.setImageDrawable(getActivity()
                        .getDrawable(R.drawable.default_song_art));
            } else {
                albumArtIv.setImageDrawable(
                        getActivity()
                                .getResources()
                                .getDrawable(R.drawable.default_song_art));
                smallAlbumArtIv.setImageDrawable(
                        getActivity()
                                .getResources()
                                .getDrawable(R.drawable.default_song_art));
            }
            updateUiColor(null);
        }

        totalTimeTv.setText(songDuration);

        ((SlidingUpPaneCallback) getActivity()).setAntiDragViewNow(musicPlayerLowerHalfLl);
        ((SlidingUpPaneCallback) getActivity()).setPaneLayout(musicPlayerSupl);
    }

