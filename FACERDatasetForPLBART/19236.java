    @Override
    public View getView(int position, View convertView, ViewGroup parent){
		FoldersMultiselectHolder holder = null;

		if (convertView==null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.folder_view_layout_multiselect, parent, false);

			holder = new FoldersMultiselectHolder();
			holder.fileFolderNameText = (TextView) convertView.findViewById(R.id.file_folder_title_multiselect);
			holder.fileFoldersCheckbox = (CheckBox) convertView.findViewById(R.id.music_folder_select_checkbox);
			holder.fileFoldersImage = (ImageView) convertView.findViewById(R.id.file_folder_icon);
			holder.fileFolderSizeText = (TextView) convertView.findViewById(R.id.file_folder_size_multiselect);

			//Apply the card layout's background based on the color theme.
			if (mWelcomeSetup==true || mApp.getCurrentTheme()==Common.LIGHT_THEME) {
				holder.fileFolderNameText.setTextColor(Color.parseColor("#2F2F2F"));
                holder.fileFolderSizeText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));

			} else if (mApp.getCurrentTheme()==Common.DARK_THEME) {
				holder.fileFolderNameText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
                holder.fileFolderSizeText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));

			}
			
			holder.fileFolderNameText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			holder.fileFolderSizeText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
			
			holder.fileFoldersImage.setImageResource(R.drawable.icon_folderblue);
			convertView.setTag(holder);
			
		} else {
		    holder = (FoldersMultiselectHolder) convertView.getTag();
		}
		
		try {
			holder.fileFolderNameText.setText(mFragment.getFileFolderNamesList().get(position));
			holder.fileFolderSizeText.setText(mFragment.getFileFolderSizesList().get(position));
			
			//Set the corresponding path of the checkbox as it's tag.
			holder.fileFoldersCheckbox.setTag(mFragment.getFileFolderPathsList().get(position));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Set the checkbox status.
		String folderPath = mFragment.getFileFolderPathsList().get(position);
		if (mDirChecked) {
			holder.fileFoldersCheckbox.setChecked(true);
			if (mFragment.getMusicFoldersHashMap().get(folderPath)!=null && 
				mFragment.getMusicFoldersHashMap().get(folderPath)==false) {
				holder.fileFoldersCheckbox.setChecked(false);
			}
			
		} else {
			holder.fileFoldersCheckbox.setChecked(false);
			if (mFragment.getMusicFoldersHashMap().get(folderPath)!=null && 
				mFragment.getMusicFoldersHashMap().get(folderPath)==true) {
				holder.fileFoldersCheckbox.setChecked(true);
			}
			
		}
		
		holder.fileFoldersCheckbox.setOnCheckedChangeListener(checkChangeListener);
		return convertView;
	}

