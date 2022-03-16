    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VideoAdapter.MyViewHolder holder = new VideoAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_video, parent,
                false));
        return holder;
    }

