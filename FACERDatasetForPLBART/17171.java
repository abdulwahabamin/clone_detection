    @Override
    public void bind(final AlbumVisitable visitable,
                     final AlbumOnClickListener onClickListener,
                     Context context) {
        albumTitleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        albumArtistTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        RequestOptions options = new RequestOptions();
        options.centerCrop().placeholder(R.drawable.default_album_art);

        if (visitable.getMediaItem().getDescription().getIconUri() != null) {
            Glide.with(context)
                    .load(visitable.getMediaItem().getDescription().getIconUri().getEncodedPath())
                    .apply(options)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(iconIv);
        } else {
            Glide.with(context).clear(iconIv);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                iconIv.setImageDrawable(context.getDrawable(R.drawable.default_album_art));
            } else {
                iconIv.setImageDrawable(
                        context
                                .getResources()
                                .getDrawable(R.drawable.default_album_art));
            }
        }

//        albumNoOfSongsTv.setText(
//                visitable
//                        .getMediaItem()
//                        .getDescription()
//                        .getExtras()
//                        .getLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS)+" tracks");

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onAlbumClick(visitable.getMediaItem(), iconIv);
            }
        });
    }

