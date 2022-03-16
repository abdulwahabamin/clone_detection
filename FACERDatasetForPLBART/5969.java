    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MusicAdapter.MyViewHolder holder = new MusicAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_music, parent,
                false));
        return holder;
    }

