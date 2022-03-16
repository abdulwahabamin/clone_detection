    public MediaListAdapter(Context context, List<MediaBrowserCompat.MediaItem> mediaItems) {
        this.context = context;
        this.mediaItems = mediaItems;
        if (context instanceof MediaListFragment.OnMediaItemSelectedListener) {
            onMediaItemSelectedListener = (MediaListFragment.OnMediaItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMediaItemSelectedListener");
        }
        if (context instanceof FirePopupMenuSelectedListener) {
            popupMenuSelectedListener = (FirePopupMenuSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FirePopupMenuSelectedListener");
        }
    }

