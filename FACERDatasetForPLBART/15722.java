        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_detail, parent, false);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) v.getLayoutParams();
            lp.height = parent.getMeasuredHeight() / 6;
            v.setLayoutParams(lp);

            v.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String playlistName = ((TextView) v).getText().toString();
                    if (songToAddId.length() == 0) {
                        SongContent.clearSongs();
                        try {
                            ArrayList<String> playlist = playlists.get(playlistName);
                            for (String s : playlist) {
                                SongContent.addItem(SongContent.ITEM_MAP.get(s));
                            }
                        } catch (Exception e) {
                            Log.e("ERROR", "onClick: ", e);
                        }
                        currentPlaylist = playlistName;
                    } else {
                        playlists.get(playlistName).add(songToAddId);
                        ItemListActivity.mydatabase.execSQL("INSERT INTO PlaylistSongs VALUES('" + playlistName + "','" + songToAddId + "');");
                        songToAddId = "";
                    }
                    Intent menuIntent = new Intent(PlaylistActivity.this, ItemListActivity.class);
                    startActivity(menuIntent);
                }
            });

            v.setTextColor(Color.WHITE);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

