    @Override
    public SongListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView;

        if(contentType == ContentType.PLAYLIST){
            contactView = inflater.inflate(R.layout.remove_song_list_item, parent, false);
        } else {
            contactView = inflater.inflate(R.layout.add_song_list_item, parent, false);
        }

        return new ViewHolder(contactView, clickListener);
    }

