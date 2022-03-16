    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder vh = (ViewHolder) view.getTag();

        String name = mActivity.fetchCategoryName(cursor);
        String displayname = name;
        boolean unknown = name == null || name.equals(MediaStore.UNKNOWN_STRING);
        if (unknown) {
            displayname = mUnknown;
        }
        vh.line1.setText(displayname);

        long id = cursor.getLong(cursor.getColumnIndexOrThrow(BaseColumns._ID));

        int numSongs = cursor.getInt(cursor.getColumnIndexOrThrow(mActivity.getNumberOfSongsColumnName()));
        vh.line2.setText(mResources.getQuantityString(R.plurals.Nsongs, numSongs, numSongs));

        long currentId = mActivity.fetchCurrentlyPlayingCategoryId();
        ImageView iv = vh.play_indicator;
        if (currentId == id) {
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.INVISIBLE);
        }
    }

