    @Override
    public RecentFileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(onDataLoadListener!=null)
            onDataLoadListener.onDataLoaded(true);
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_item_view,parent,false);

        return new RecentFileViewHolder(v);
    }

