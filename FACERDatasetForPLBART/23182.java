    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
            final SongInfo s = _songs.get(i);
            songHolder.tvSongName.setText(_songs.get(i).getSongname());
            songHolder.tvSongArtist.setText(_songs.get(i).getArtistname());
            songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(songHolder.btnAction,v, s, i);
                    }
                }
            });
    }

