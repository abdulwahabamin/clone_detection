    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CityRowUtilitiesViewHolder holder = (CityRowUtilitiesViewHolder) view.getTag();
        int nameColumnsIndex = cursor.getColumnIndexOrThrow(CityTable.COLUMN_NAME);
        holder.cityNameTextView.setText(cursor.getString(nameColumnsIndex));
    }

