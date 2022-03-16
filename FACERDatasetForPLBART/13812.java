    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull final ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.playlist_song_item, null);
            holder = new ViewHolder();
            holder.musicName = view.findViewById(R.id.name);
            holder.remove = view.findViewById(R.id.item_remove);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String name = "Song name: " + musicArrayList.get(position).getName();
        holder.musicName.setText(name);
        holder.musicName.setTag(name);
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFromQueue(position);
                musicArrayList.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }

