	/**
	 * Returns the individual row/child in the list/grid.
	 */
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        Cursor c = (Cursor) getItem(position);

		if (convertView==null) {
			mHolder = new GridViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_view_item, parent, false);

            mHolder.background = (RelativeLayout) convertView.findViewById(R.id.gridViewItemLayout);
            mHolder.textLayout = (RelativeLayout) convertView.findViewById(R.id.gridViewTextLayout);
			mHolder.gridViewArt = (ImageView) convertView.findViewById(R.id.gridViewImage);
			mHolder.titleText = (TextView) convertView.findViewById(R.id.gridViewTitleText);
            mHolder.subText = (TextView) convertView.findViewById(R.id.gridViewSubText);

			mHolder.overflowButton = (ImageButton) convertView.findViewById(R.id.gridViewOverflowButton);
            mHolder.overflowButton.setImageResource(UIElementsHelper.getIcon(mContext, "ic_action_overflow"));
			mHolder.overflowButton.setOnClickListener(overflowClickListener);
			mHolder.overflowButton.setFocusable(false);
			mHolder.overflowButton.setFocusableInTouchMode(false);

			mHolder.titleText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
            mHolder.subText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			
	        mHolder.gridViewArt.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mHolder.gridViewArt.setImageResource(UIElementsHelper.getEmptyColorPatch(mContext));
            //mHolder.textLayout.setBackgroundColor(UIElementsHelper.getGridViewBackground(mContext));
            //mHolder.overflowButton.setBackgroundColor(UIElementsHelper.getGridViewBackground(mContext));
            mHolder.titleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
            mHolder.subText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));

            //Apply the ImageView's dimensions.
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mHolder.gridViewArt.getLayoutParams();
            params.width = mWidth;
            params.height = mWidth;
            mHolder.gridViewArt.setLayoutParams(params);

            //Apply the card's background.
            mHolder.background.setBackgroundResource(UIElementsHelper.getGridViewCardBackground(mContext));
			
			convertView.setTag(mHolder);
		} else {
		    mHolder = (GridViewHolder) convertView.getTag();
		}
		
		//Retrieve data from the cursor.
		String titleText = "";
		String source = "";
		String filePath = "";
		String artworkPath = "";
		String field1 = "";
		String field2 = "";
		String field3 = "";
		String field4 = "";
		String field5 = "";
		try {
			titleText = c.getString(c.getColumnIndex(mDBColumnsMap.get(TITLE_TEXT)));
			source = c.getString(c.getColumnIndex(mDBColumnsMap.get(SOURCE)));
			filePath = c.getString(c.getColumnIndex(mDBColumnsMap.get(FILE_PATH)));
			artworkPath = c.getString(c.getColumnIndex(mDBColumnsMap.get(ARTWORK_PATH)));
			field1 = c.getString(c.getColumnIndex(mDBColumnsMap.get(FIELD_1)));
			field2 = c.getString(c.getColumnIndex(mDBColumnsMap.get(FIELD_2)));
			field3 = c.getString(c.getColumnIndex(mDBColumnsMap.get(FIELD_3)));
			field4 = c.getString(c.getColumnIndex(mDBColumnsMap.get(FIELD_4)));
			field5 = c.getString(c.getColumnIndex(mDBColumnsMap.get(FIELD_5)));
			
		} catch (NullPointerException e) {
			//e.printStackTrace();
		}
		
		//Set the tags for this grid item.
		convertView.setTag(R.string.title_text, titleText);
		convertView.setTag(R.string.song_source, source);
		convertView.setTag(R.string.song_file_path, filePath);
		convertView.setTag(R.string.album_art, artworkPath);
		convertView.setTag(R.string.field_1, field1);
		convertView.setTag(R.string.field_2, field2);
		convertView.setTag(R.string.field_3, field3);
		convertView.setTag(R.string.field_4, field4);
		convertView.setTag(R.string.field_5, field5);
		
		/*//Set the tags for this grid item's overflow button.
		mHolder.overflowButton.setTag(R.string.title_text, titleText);
		mHolder.overflowButton.setTag(R.string.source, source);
		mHolder.overflowButton.setTag(R.string.file_path, filePath);
		mHolder.overflowButton.setTag(R.string.field_1, field1);
		mHolder.overflowButton.setTag(R.string.field_2, field2);
		mHolder.overflowButton.setTag(R.string.field_3, field3);
		mHolder.overflowButton.setTag(R.string.field_4, field4);
		mHolder.overflowButton.setTag(R.string.field_5, field5);*/
		
		//Set the title text in the GridView.
		mHolder.titleText.setText(titleText);
        mHolder.subText.setText(field1);

		//Load the album art.
        mApp.getPicasso().load(artworkPath)
                         .placeholder(UIElementsHelper.getEmptyColorPatch(mContext))
                         .into(mHolder.gridViewArt);

		return convertView;
	}

