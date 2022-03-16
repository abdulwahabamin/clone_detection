    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_song_sliding_queue, null);
        ItemHolder ml = new ItemHolder(v);
        return ml;
    }

