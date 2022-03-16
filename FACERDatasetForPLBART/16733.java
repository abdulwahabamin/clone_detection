    private void setItemClickListener(MyViewHolder myViewHolder, final MediaBrowserCompat.MediaItem mediaItem) {
        myViewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMediaItemSelectedListener.onMediaItemSelected(mediaItem);
            }
        });
    }

