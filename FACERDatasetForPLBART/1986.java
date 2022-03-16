    @Override
    public HorizontalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.horizontal_item_view, parent, false);
      return new HorizontalAdapter.MyViewHolder(itemView);
    }

