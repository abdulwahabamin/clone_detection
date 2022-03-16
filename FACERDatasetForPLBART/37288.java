    public RViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        context = itemView.getContext();
        ViewBinder.bind(this, itemView);
    }

