    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (currentSearchResults.get(position).getResultType()) {
            case SONG:
                SongViewHolder songViewHolder = (SongViewHolder) holder;
                songViewHolder.songTitle.setText(currentSearchResults.get(position).getMainTitle());
                songViewHolder.songDuration.setText(currentSearchResults.get(position).getSubTitle());
                break;

            case ALBUM:
                AlbumViewHolder albumViewHolder = (AlbumViewHolder) holder;
                albumViewHolder.albumTitle.setText(currentSearchResults.get(position).getMainTitle());
                albumViewHolder.artistTitle.setText(currentSearchResults.get(position).getSubTitle());
                break;

            case ARTIST:
                ArtistViewHolder artistViewHolder = (ArtistViewHolder) holder;
                artistViewHolder.artistName.setText(currentSearchResults.get(position).getMainTitle());
                artistViewHolder.artistDetails.setText(currentSearchResults.get(position).getSubTitle());
                break;
            case HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.headerText.setText(currentSearchResults.get(position).getMainTitle());
                break;
        }

    }

