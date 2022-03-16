    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View rowView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.row_city_list_with_utils_buttons, parent, false);

        CityRowUtilitiesViewHolder holder = new CityRowUtilitiesViewHolder();
        holder.cityNameTextView = (TextView) rowView
                .findViewById(R.id.city_name_in_list_row_text_view);
        holder.buttonRename = (ImageView) rowView.findViewById(R.id.city_rename_button);
        holder.buttonRename.setOnClickListener(onClickListener);
        holder.buttonDelete = (ImageView) rowView.findViewById(R.id.city_remove_button);
        if (isRemovalModeButton) {
            holder.buttonDelete.setVisibility(View.VISIBLE);
            holder.buttonDelete.setOnClickListener(onClickListener);
        } else {
            holder.buttonDelete.setVisibility(View.GONE);
        }

        rowView.setTag(holder);
        return rowView;
    }

