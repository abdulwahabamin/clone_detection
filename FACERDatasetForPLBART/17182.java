    @Override
    public void bind(final PlaylistVisitable visitable,
                     final PlaylistOnClickListener onClickListener,
                     Context context) {
        titleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        subtitleTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        RequestOptions options = new RequestOptions();
        options.centerCrop().placeholder(R.drawable.default_album_art);

        Bundle bundle = visitable.getMediaItem().getDescription().getExtras();

        if (bundle != null) {
            int iconDrawableId =
                    (int) bundle.getLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_ICON_DRAWABLE_ID);
            int color =
                    (int) bundle.getLong(PlaylistsSource.CUSTOM_METADATA_KEY_PLAYLIST_COLOR);

            if (iconDrawableId != 0) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    iconIv.setImageDrawable(context.getDrawable(iconDrawableId));
                } else {
                    iconIv.setImageDrawable(
                            context
                                    .getResources()
                                    .getDrawable(iconDrawableId));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    iconIv.setImageDrawable(context.getDrawable(R.drawable.ic_playlist_play_blue_grey_300_24dp));
                } else {
                    iconIv.setImageDrawable(
                            context
                                    .getResources()
                                    .getDrawable(R.drawable.ic_playlist_play_blue_grey_300_24dp));
                }
            }

            if (color != 0) {
                iconIv.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    iconIv
                            .setColorFilter(
                                    context.getResources().getColor(R.color.blueGrey300, null),
                                    PorterDuff.Mode.SRC_IN);
                } else {
                    iconIv
                            .setColorFilter(
                                    context.getResources().getColor(R.color.blueGrey300),
                                    PorterDuff.Mode.SRC_IN);
                }
            }
        }

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onPlaylistClick(visitable.getMediaItem(), iconIv);
            }
        });
    }

