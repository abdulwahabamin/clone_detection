    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Category.TRACK:
            case Category.ALBUM:
            case Category.ARTIST:
            default:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_row, parent, false);
                return new MyViewHolder(itemView);
            case Category.NONE:
                View itemView2 = LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);
                return new MyViewHolder(itemView2);
        }
    }

