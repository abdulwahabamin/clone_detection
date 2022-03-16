    @Override
    public AlbumGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(contactView, clickListener);
    }

