    public View getView(final int position, View convertView, ViewGroup parent){
    	
    	SongsListViewHolder holder = null;
		if (convertView == null) {	
			convertView = LayoutInflater.from(mContext).inflate(R.layout.sliding_menu_list_layout, parent, false);
			holder = new SongsListViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.sliding_menu_list_item);
			holder.image = (ImageView) convertView.findViewById(R.id.sliding_menu_libraries_icon);
			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}

		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.title.setPaintFlags(holder.title.getPaintFlags()
										 | Paint.ANTI_ALIAS_FLAG
										 | Paint.SUBPIXEL_TEXT_FLAG);		
		
		holder.title.setText(mColorsList.get(position));

		//Set the icon.
		switch(position) {
		case 0:
			holder.image.setImageResource(R.drawable.circle_blue_dark);
			break;
		case 1:
			holder.image.setImageResource(R.drawable.circle_blue_light);
			break;
		case 2:
			holder.image.setImageResource(R.drawable.circle_green_dark);
			break;
		case 3:
			holder.image.setImageResource(R.drawable.circle_green_light);
			break;
		case 4:
			holder.image.setImageResource(R.drawable.circle_purple_dark);
			break;
		case 5:
			holder.image.setImageResource(R.drawable.circle_purple_light);
			break;
		case 6:
			holder.image.setImageResource(R.drawable.circle_red_dark);
			break;
		case 7:
			holder.image.setImageResource(R.drawable.circle_red_light);
			break;
		case 8:
			holder.image.setImageResource(R.drawable.circle_yellow_dark);
			break;
		case 9:
			holder.image.setImageResource(R.drawable.circle_yellow_light);
			break;
		}
		
		return convertView;

	}

