    public View getView(final int position, View convertView, ViewGroup parent){

        QueueDrawerHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(mContext)
                                        .inflate(R.layout.queue_drawer_list_layout, parent, false);

            holder = new QueueDrawerHolder();
            holder.songTitleText = (TextView) convertView.findViewById(R.id.queue_song_title);
            holder.artistText = (TextView) convertView.findViewById(R.id.queue_song_artist);
            holder.removeSong = (ImageView) convertView.findViewById(R.id.queue_remove_song);

            holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
            holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            holder.songTitleText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
            holder.artistText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

            convertView.setTag(holder);
        } else {
            holder = (QueueDrawerHolder) convertView.getTag();
        }

        //Get the song's basic info.
        SongHelper songHelper = new SongHelper();
        songHelper.populateBasicSongData(mContext, position);

        holder.songTitleText.setText(songHelper.getTitle());
        holder.artistText.setText(songHelper.getArtist());

        //Apply the item's colors.
        try {
            if (position==mApp.getService().getCurrentSongIndex()) {
                holder.songTitleText.setTextColor(mColors[0]);
                holder.artistText.setTextColor(mColors[0]);
            } else if (mApp.getCurrentTheme()==Common.LIGHT_THEME) {
                holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
                holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            } else if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
                holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }

