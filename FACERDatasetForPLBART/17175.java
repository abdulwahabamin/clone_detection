    @Override
    public void bind(final ArtistSongVisitable visitable,
                     final SongOnClickListener onClickListener,
                     Context context) {
        songTitleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        songDurationTv.setText(
                getFormattedDuration(
                        visitable
                                .getMediaItem()
                                .getDescription()
                                .getExtras()
                                .getLong(MediaMetadataCompat.METADATA_KEY_DURATION)
                )
        );

        songAlbumTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        if (visitable.getMediaItem().getDescription().getIconUri() != null) {
            Glide.with(context)
                    .load(visitable.getMediaItem().getDescription().getIconUri().getEncodedPath())
                    .apply(options)
                    .into(iconIv);
        } else {
            Glide.with(context).clear(iconIv);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                iconIv.setImageDrawable(context.getDrawable(R.drawable.default_song_art));
            } else {
                iconIv.setImageDrawable(
                        context
                                .getResources()
                                .getDrawable(R.drawable.default_song_art));
            }
        }

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onSongClick(visitable.getMediaItem());
            }
        });
    }

