    /**
     * Constructor.
     *
     * @param itemView The view that contains the fields that are to be set for each list item.
     */
    public ItemViewHolder(View itemView) {
        super(itemView);
        tvInformation = (TextView) itemView.findViewById(R.id.city_overview_list_item_text);
        isDefault = (ImageView) itemView.findViewById(R.id.locationDefault);
    }

