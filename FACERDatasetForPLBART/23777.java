    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.album_spinner_row, parent, false);
            mViewHolder.mImage = convertView.findViewById(R.id.album_spinner_image);
            mViewHolder.mName = convertView.findViewById(R.id.album_spinner_text);
            convertView.setTag(mViewHolder);
        } else {
            //Log.d(TAG,"getView() - Recycling view");
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        try {
            Album a = mAlbums.get(position);
            mViewHolder.mName.setText(a.getTitle());
            mImageLoader.loadImage(a.getImageId(), mViewHolder.mImage);
        } catch (Exception e) {
            mViewHolder.mName.setText(R.string.unknown);
            mViewHolder.mImage.setImageResource(R.drawable.ic_launcher_icon);
        }
        return convertView;
    }

