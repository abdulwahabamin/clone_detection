    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	FoldersViewHolder holder = null;
		if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);
            ListView.LayoutParams params = (ListView.LayoutParams) convertView.getLayoutParams();
            params.height = (int) mApp.convertDpToPixels(72.0f, mContext);
            convertView.setLayoutParams(params);

			holder = new FoldersViewHolder();
			holder.fileFolderIcon = (ImageView) convertView.findViewById(R.id.listViewLeftIcon);
			holder.fileFolderSizeText = (TextView) convertView.findViewById(R.id.listViewSubText);
			holder.fileFolderNameText = (TextView) convertView.findViewById(R.id.listViewTitleText);
            holder.overflowButton = (ImageButton) convertView.findViewById(R.id.listViewOverflow);
            holder.rightSubText = (TextView) convertView.findViewById(R.id.listViewRightSubText);

            holder.fileFolderIcon.setScaleX(0.5f);
            holder.fileFolderIcon.setScaleY(0.55f);
            holder.rightSubText.setVisibility(View.INVISIBLE);

			holder.fileFolderNameText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
			holder.fileFolderNameText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			
			holder.fileFolderSizeText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
			holder.fileFolderSizeText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

            holder.overflowButton.setImageResource(UIElementsHelper.getIcon(mContext, "ic_action_overflow"));
            holder.overflowButton.setFocusable(false);
            holder.overflowButton.setFocusableInTouchMode(false);
			holder.overflowButton.setOnClickListener(overflowClickListener);

			convertView.setTag(holder);
		} else {
		    holder = (FoldersViewHolder) convertView.getTag();
		}
		
		holder.fileFolderNameText.setText(mFileFolderNameList.get(position));
		holder.fileFolderSizeText.setText(mFileFolderSizeList.get(position));
		
		//Set the icon based on whether the item is a folder or a file.
		if (mFileFolderTypeList.get(position)==FilesFoldersFragment.FOLDER) {
			holder.fileFolderIcon.setImageResource(R.drawable.icon_folderblue);
			convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.FOLDER);
			convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

		} else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.AUDIO_FILE) {
			holder.fileFolderIcon.setImageResource(R.drawable.icon_mp3);
			convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.AUDIO_FILE);
			convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

		} else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.PICTURE_FILE) {
			holder.fileFolderIcon.setImageResource(R.drawable.icon_png);
			convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.PICTURE_FILE);
			convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

		} else if (mFileFolderTypeList.get(position)==FilesFoldersFragment.VIDEO_FILE) {
			holder.fileFolderIcon.setImageResource(R.drawable.icon_avi);
			convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.VIDEO_FILE);
			convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

		} else {
			holder.fileFolderIcon.setImageResource(R.drawable.icon_default);
			convertView.setTag(R.string.folder_list_item_type, FilesFoldersFragment.FILE);
			convertView.setTag(R.string.folder_path, mFileFolderPathsList.get(position));
            convertView.setTag(R.string.position, position);

		}
    	
    	return convertView;
	}

