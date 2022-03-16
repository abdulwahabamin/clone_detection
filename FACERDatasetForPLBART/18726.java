        @Override
        public void onClick(View v) {
            PopupMenu menu = new PopupMenu(mContext, v);
            menu.inflate(R.menu.file_folder_overflow_menu);
            menu.setOnMenuItemClickListener(popupMenuItemClickListener);
            mItemType = (Integer) ((View) v.getParent()).getTag(R.string.folder_list_item_type);
            mItemPath = (String) ((View) v.getParent()).getTag(R.string.folder_path);
            mItemPosition = (Integer) ((View) v.getParent()).getTag(R.string.position);
            menu.show();

        }

