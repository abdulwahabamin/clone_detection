    @Override
    public ForecastOverviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout
        final View itemView = LayoutInflater.from(context).inflate(R.layout.daycard, parent, false);
        itemView.setOnClickListener(this);
        // Return a new holder instance
        return new ForecastOverviewAdapter.ViewHolder(itemView);
    }

