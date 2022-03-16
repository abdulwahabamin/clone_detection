    @Override
    public BaseViewHolder createViewHolder(View parent, int type) {
        BaseViewHolder viewHolder = null;

        switch (type) {
            case SongViewHolder.LAYOUT:
                viewHolder = new SongViewHolder(parent);
                break;
            case AlbumViewHolder.LAYOUT:
                viewHolder = new AlbumViewHolder(parent);
                break;
            case ArtistViewHolder.LAYOUT:
                viewHolder = new ArtistViewHolder(parent);
                break;
            case QueueItemViewHolder.LAYOUT:
                viewHolder = new QueueItemViewHolder(parent);
                break;
            case SearchResultViewHolder.LAYOUT:
                viewHolder = new SearchResultViewHolder(parent);
                break;
            case SongSearchResultViewHolder.LAYOUT:
                viewHolder = new SongSearchResultViewHolder(parent);
                break;
            case AlbumSearchResultViewHolder.LAYOUT:
                viewHolder = new AlbumSearchResultViewHolder(parent);
                break;
            case ArtistSearchResultViewHolder.LAYOUT:
                viewHolder = new ArtistSearchResultViewHolder(parent);
                break;
            case SearchItemTypeTitleViewHolder.LAYOUT:
                viewHolder = new SearchItemTypeTitleViewHolder(parent);
                break;
            case AlbumSongViewHolder.LAYOUT:
                viewHolder = new AlbumSongViewHolder(parent);
                break;
            case ArtistSongViewHolder.LAYOUT:
                viewHolder = new ArtistSongViewHolder(parent);
                break;
            case ShuffleAllSongsViewHolder.LAYOUT:
                viewHolder = new ShuffleAllSongsViewHolder(parent);
                break;
            case PlaylistViewHolder.LAYOUT:
                viewHolder = new PlaylistViewHolder(parent);
                break;
            case DetailTitleViewHolder.LAYOUT:
                viewHolder = new DetailTitleViewHolder(parent);
                break;
        }

        return viewHolder;
    }

