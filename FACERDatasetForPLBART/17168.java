    @Override
    public void bind(final AlbumSongVisitable visitable,
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

        songArtistTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        trackNoTv.setText(visitable
                                .getMediaItem()
                                .getDescription()
                                .getExtras()
                                .getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)+"");

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onSongClick(visitable.getMediaItem());
            }
        });
    }

