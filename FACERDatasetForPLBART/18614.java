    /**
     * This method returns the view for the drop down menu list.
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Cursor c = (Cursor) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.sliding_menu_list_layout, parent, false);
            holder = new LibrariesListViewHolder();

            holder.tagColor = (ImageView) convertView.findViewById(R.id.sliding_menu_libraries_icon);
            holder.title = (TextView) convertView.findViewById(R.id.sliding_menu_list_item);

            holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
            convertView.setTag(holder);
        } else {
            holder = (LibrariesListViewHolder) convertView.getTag();
        }

        //Retrieve the library's parameters.
        String libraryName = c.getString(c.getColumnIndex(DBAccessHelper.LIBRARY_NAME));
        String libraryColorCode = c.getString(c.getColumnIndex(DBAccessHelper.LIBRARY_TAG));

        //Construct the library color tag drawable from the given color code string.
        int colorCodeDrawableID = 0;
        try {
            colorCodeDrawableID = mContext.getResources().getIdentifier(libraryColorCode, "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set the tag for this child view. The key is required to be an application-defined key.
        convertView.setTag(R.string.library_name, libraryName);
        convertView.setTag(R.string.library_color_code, libraryColorCode);

        holder.title.setText(libraryName);
        holder.tagColor.setImageResource(colorCodeDrawableID);

        return convertView;
    }

