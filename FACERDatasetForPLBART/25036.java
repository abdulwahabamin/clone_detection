    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_SONG:
                ViewGroup vSong = (ViewGroup) mInflater.inflate(R.layout.search_song_item, parent, false);
                return new SongViewHolder(vSong);
            case TYPE_ALBUM:
                ViewGroup vAlbum = (ViewGroup) mInflater.inflate(R.layout.search_album_item, parent, false);
                return new AlbumViewHolder(vAlbum);
            case TYPE_ARTIST:
                ViewGroup vArtist = (ViewGroup) mInflater.inflate(R.layout.search_artist_item, parent, false);
                return new ArtistViewHolder(vArtist);
            case TYPE_HEADER:
                ViewGroup vHeader = (ViewGroup) mInflater.inflate(R.layout.search_header, parent, false);
                return new HeaderViewHolder(vHeader);
            default:
                ViewGroup vDefault = (ViewGroup) mInflater.inflate(R.layout.search_song_item, parent, false);
                return new SongViewHolder(vDefault);
        }
    }

