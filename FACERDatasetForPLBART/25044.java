        public AlbumViewHolder(View v) {
            super(v);
            albumTitle = (TextView) v.findViewById(R.id.txt_album_title);
            artistTitle = (TextView) v.findViewById(R.id.txt_album_artist);
            v.setOnClickListener(this);
        }

