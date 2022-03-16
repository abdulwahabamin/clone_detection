    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.place, parent, false);
        // Return a new holder instance
        return new PlaceAdapter.ViewHolder(itemView);
    }

