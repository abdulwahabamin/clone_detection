    public AlbumSpinnerAdaptor(@NonNull Context context, ArrayList<Album> albums, ImageLoader loader) {
        super(context, R.layout.album_spinner_row);
        this.mAlbums = albums;
        this.mContext = context;
        this.mImageLoader = loader;
    }

