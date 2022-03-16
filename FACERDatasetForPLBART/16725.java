    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MediaBrowserCompat.MediaItem mediaItem = mediaItems.get(position);
        holder.title.setText(mediaItem.getDescription().getTitle());
        ImageHelper.loadArt(context, holder.image, mediaItem.getDescription());
    }

