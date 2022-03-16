    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);

        Cursor mCursor = (Cursor) getItem(position);
        // ViewHolderList
        final ViewHolderList viewholder;

        if (view != null) {

            viewholder = new ViewHolderList(view);
            holderReference = new WeakReference<ViewHolderList>(viewholder);
            view.setTag(holderReference.get());

        } else {
            viewholder = (ViewHolderList)convertView.getTag();
        }

        String playlist_name = mCursor.getString(PlaylistsFragment.mPlaylistNameIndex);
        holderReference.get().mViewHolderLineOne.setText(playlist_name);

        // Helps center the text in the Playlist tab
        int left = mContext.getResources().getDimensionPixelSize(
                R.dimen.listview_items_padding_left_top);
        holderReference.get().mViewHolderLineOne.setPadding(left, 40, 0, 0);

        holderReference.get().mViewHolderImage.setVisibility(View.GONE);

        holderReference.get().mQuickContext.setOnClickListener(showContextMenu);
        return view;
    }

