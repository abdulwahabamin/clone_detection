    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CityRowWeatherViewHolder holder = (CityRowWeatherViewHolder) view.getTag();
        int nameColumnsIndex = cursor.getColumnIndexOrThrow(CityTable.COLUMN_NAME);
        holder.cityNameTextView.setText(cursor.getString(nameColumnsIndex));
    }

