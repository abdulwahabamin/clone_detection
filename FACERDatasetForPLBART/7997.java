    /**********************
     * ViewHolder
     **********************/
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup vg, int i) {
        View itemView = LayoutInflater.from(vg.getContext()).
                inflate(R.layout.list_item_layout, vg, false);

        return new ItemViewHolder(itemView);
    }

