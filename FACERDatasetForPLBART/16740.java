    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        MediaItemWrapper mediaItemWrapper = mediaItemWrappers.get(position);
        MediaBrowserCompat.MediaItem mediaItem = mediaItemWrapper.getMediaItem();
        switch (getItemViewType(position)) {
            case Category.TRACK:
                myViewHolder.title.setText(mediaItem.getDescription().getTitle());
                myViewHolder.detail.setText(mediaItem.getDescription().getSubtitle());
                myViewHolder.popupMenuBtn.setVisibility(View.VISIBLE);
                setOnItemClickListener(myViewHolder, mediaItemWrapper);
                setOnPopupMenuListener(myViewHolder, mediaItem);
                ImageHelper.loadArt(context, myViewHolder.albumArt, mediaItem.getDescription());
                break;
            case Category.ALBUM:
                myViewHolder.title.setText(mediaItem.getDescription().getTitle());
                myViewHolder.detail.setText(mediaItem.getDescription().getSubtitle());
                myViewHolder.popupMenuBtn.setVisibility(View.GONE);
                setOnItemClickListener(myViewHolder, mediaItemWrapper);
                ImageHelper.loadArt(context, myViewHolder.albumArt, mediaItem.getDescription());
                break;
            case Category.ARTIST:
                myViewHolder.title.setText(mediaItem.getDescription().getTitle());
                myViewHolder.popupMenuBtn.setVisibility(View.GONE);
                setOnItemClickListener(myViewHolder, mediaItemWrapper);
                ImageHelper.loadArt(context, myViewHolder.albumArt, mediaItem.getDescription());
                break;
            case Category.NONE:
                myViewHolder.sectionHeader.setTextColor(context.getResources().getColor(R.color.white));
                myViewHolder.sectionHeader.setText(mediaItemWrapper.getTypeTitle());
        }
    }

