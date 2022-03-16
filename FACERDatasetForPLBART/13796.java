    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull final ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.downloaded_song_item, null);
            holder = new ViewHolder();
            holder.musicName = view.findViewById(R.id.name);
            holder.artistName = view.findViewById(R.id.artist);
            holder.duration = view.findViewById(R.id.duration);
            holder.thumbnail = view.findViewById(R.id.thumbnail);
            holder.menu = view.findViewById(R.id.item_menu);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final String name = "Song name: " + filteredMusicArrayList.get(position).getName();
        holder.musicName.setText(name);
        holder.musicName.setTag(name);
        String artist = "Artist: " + filteredMusicArrayList.get(position).getArtistName();
        holder.artistName.setText(artist);
        holder.artistName.setTag(artist);
        long milliseconds = Long.parseLong(filteredMusicArrayList.get(position).getDuration());
        String timeDuration = "Duration: " + Utility.getLength(milliseconds);
        holder.duration.setText(timeDuration);
        holder.duration.setTag(timeDuration);
        String imageURL = filteredMusicArrayList.get(position).getImageLink();
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
        final Uri uri = filteredMusicArrayList.get(position).getUri();
        final boolean isFavorite = filteredMusicArrayList.get(position).isFavorite();
        final int id = filteredMusicArrayList.get(position).getId();
        final Music music = filteredMusicArrayList.get(position);
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(parent.getContext(), view);
                popup.getMenuInflater().inflate(R.menu.music_menu,
                        popup.getMenu());
                if (isFavorite) {
                    MenuItem menuItem = popup.getMenu().findItem(R.id.add_to_favorite);
                    menuItem.setTitle(R.string.remove_favorite);
                }
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.play:
                                //play the music
                                playMusic(music);
                                break;
                            case R.id.add_to_queue:
                                //add music to the current playing queue
                                addToQueue(music);
                                break;
                            case R.id.add_to_favorite:
                                //add to favorite list
                                if (isFavorite) {
                                    dbHandler.removeFavorite(id);
                                    musicArrayList.remove(getItem(position));
                                    filteredMusicArrayList.remove(position);
                                    notifyDataSetChanged();
                                } else {
                                    long favId = dbHandler.addFavorite(id);
                                    if (favId > 0) {
                                        Toast.makeText(getContext(), name + " Added to favorites", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), name + " Already added to favorites", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                break;
                            case R.id.delete:
                                //delete the file
                                deleteFile(uri, name, position);
                                break;
                            case R.id.share_file:
                                //share the file
                                shareFile(uri, name);
                                break;
                            default:
                                break;
                        }

                        return true;
                    }
                });
            }
        });
        return view;
    }

