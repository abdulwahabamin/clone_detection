	/**
	 * Returns the individual row/child in the list/grid.
	 */
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        Cursor c = (Cursor) getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);

			mHolder = new ListViewHolder();
			mHolder.leftImage = (ImageView) convertView.findViewById(R.id.listViewLeftIcon);
			mHolder.titleText = (TextView) convertView.findViewById(R.id.listViewTitleText);
			mHolder.subText = (TextView) convertView.findViewById(R.id.listViewSubText);
			mHolder.rightSubText = (TextView) convertView.findViewById(R.id.listViewRightSubText);
            mHolder.overflowIcon = (ImageButton) convertView.findViewById(R.id.listViewOverflow);
            mHolder.subTextParent = (RelativeLayout) convertView.findViewById(R.id.listViewSubTextParent);

            //Remove the sub text's parent layout for playlists list view.
            if (mListViewFragment.getFragmentId()==Common.PLAYLISTS_FRAGMENT) {
                mHolder.subTextParent.setVisibility(View.GONE);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mHolder.titleText.getLayoutParams();
                params.addRule(RelativeLayout.CENTER_VERTICAL);
                mHolder.titleText.setLayoutParams(params);

            }

			mHolder.titleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
            mHolder.subText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            mHolder.rightSubText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            mHolder.leftImage.setImageResource(UIElementsHelper.getEmptyCircularColorPatch(mContext));
			
			mHolder.titleText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			mHolder.subText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			mHolder.rightSubText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

            mHolder.overflowIcon.setImageResource(UIElementsHelper.getIcon(mContext, "ic_action_overflow"));
			mHolder.overflowIcon.setOnClickListener(overflowClickListener);
			mHolder.overflowIcon.setFocusable(false);
			mHolder.overflowIcon.setFocusableInTouchMode(false);
			
			convertView.setTag(mHolder);
		} else {
		    mHolder = (ListViewHolder) convertView.getTag();
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
		
		//Set the tags for this list item's overflow button.
		mHolder.overflowIcon.setTag(R.string.title_text, titleText);
		mHolder.overflowIcon.setTag(R.string.source, source);
		mHolder.overflowIcon.setTag(R.string.file_path, filePath);
		mHolder.overflowIcon.setTag(R.string.field_1, field1);
		mHolder.overflowIcon.setTag(R.string.field_2, field2);
		mHolder.overflowIcon.setTag(R.string.field_3, field3);
		mHolder.overflowIcon.setTag(R.string.field_4, field4);
		mHolder.overflowIcon.setTag(R.string.field_5, field5);
		
		//Set the title text in the ListView.
		mHolder.titleText.setText(titleText);
		mHolder.subText.setText(field2);
		mHolder.rightSubText.setText(field1);

		//Load the album art.
        mApp.getPicasso().load(artworkPath)
                         .transform(new PicassoCircularTransformer())
                         .placeholder(UIElementsHelper.getEmptyCircularColorPatch(mContext))
                         .resizeDimen(R.dimen.list_view_left_icon_size, R.dimen.list_view_left_icon_size)
                         .into(mHolder.leftImage);
		
		return convertView;
	}

