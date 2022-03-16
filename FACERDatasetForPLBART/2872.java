    @Override
    public ZipAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ZipAdapter.MyViewHolder holder = new ZipAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_zip, parent,
                false));
        return holder;
    }

