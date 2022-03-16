    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null || convertView.getTag() == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);

            holder = new ViewHolder();
            holder.gridItemImage = (ImageView) convertView.findViewById(R.id.grid_image);
            holder.gridItemImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.gridItemTitle = (TextView) convertView.findViewById(R.id.grid_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.gridItemImage.setImageResource(R.drawable.ic_play_arrow_white_24dp);
        byte[] imageData = MusicDataUtility.getImageData(songs.get(position).getSongLocation());
        if (imageData != null) {
            Bitmap bmp = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
            holder.gridItemImage.setImageBitmap(bmp);
        }

        holder.gridItemTitle.setText(songs.get(position).getSongTitle());
        return convertView;
    }

