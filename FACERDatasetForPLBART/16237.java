    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Music music = datas.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.view_music_item, parent, false);
            holder.tvSong = convertView.findViewById(R.id.music_item_tv_song);
            holder.tvDuration = convertView.findViewById(R.id.music_item_tv_duration);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvSong.setText(music.getName());
        holder.tvDuration.setText(MusicUtil.formatTime(music.getDuration()));
        return convertView;
    }

