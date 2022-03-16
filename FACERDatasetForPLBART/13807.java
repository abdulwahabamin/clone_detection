    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull final ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.online_song_item, null);
            holder = new ViewHolder();
            holder.musicName = view.findViewById(R.id.name);
            holder.artistName = view.findViewById(R.id.artist);
            holder.duration = view.findViewById(R.id.duration);
            holder.thumbnail = view.findViewById(R.id.thumbnail);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String name = "Song name: " + musicArrayList.get(position).getName();
        holder.musicName.setText(name);
        holder.musicName.setTag(name);
        String artist = "Artist: " + musicArrayList.get(position).getArtistName();
        holder.artistName.setText(artist);
        holder.artistName.setTag(artist);
        long milliseconds = Long.parseLong(musicArrayList.get(position).getDuration());
        String timeDuration = "Duration: " + Utility.getLength(milliseconds);
        holder.duration.setText(timeDuration);
        holder.duration.setTag(timeDuration);
        String imageURL = musicArrayList.get(position).getImageLink();
        if (!TextUtils.isEmpty(imageURL)) {
            Picasso.with(parent.getContext())
                    .load(imageURL)
                    .placeholder(R.drawable.ic_music_thumbnail)
                    .resize(60, 60)
                    .centerCrop()
                    .error(R.drawable.ic_music_thumbnail)
                    .into(holder.thumbnail);
            holder.thumbnail.setTag(imageURL);
        }
        return view;
    }

