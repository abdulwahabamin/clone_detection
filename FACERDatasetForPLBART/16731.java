    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MediaBrowserCompat.MediaItem mediaItem = mediaItems.get(position);
        MediaDescriptionCompat description = mediaItem.getDescription();
        holder.title.setText(description.getTitle());
        holder.detail.setText(description.getSubtitle());
        ImageHelper.loadArt(context, holder.albumArt, description);
        setItemClickListener(holder, mediaItem);
        setOnPopupMenuListener(holder, mediaItem);
    }

