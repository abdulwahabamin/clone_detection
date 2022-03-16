    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MediaItem detail=mItemsList.get(position);
        holder.SongName.setText(detail.getTitle());
        holder.ArtistAlbumName.setText(detail.getArtist() + " | " + detail.getAlbum());
        if (PlayerConstants.mSongPlayback.isPlay){
            holder.isPlayImage.setImageResource(R.drawable.pause);
        }
        else
        {
            holder.isPlayImage.setImageResource(R.drawable.play);
        }

        holder.isPlayImage.setVisibility(View.INVISIBLE);
        if (PlayerConstants.SONG_NUMBER>-1 && PlayerConstants.SONG_NUMBER==position)
        {
            holder.isPlayImage.setVisibility(View.VISIBLE);
        }
    }

