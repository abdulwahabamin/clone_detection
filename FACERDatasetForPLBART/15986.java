        AlbumHolder(View itemView) {
            super(itemView);

            albumArt = (ImageView) itemView.findViewById(R.id.album_album_art);
            albumName = (TextView) itemView.findViewById(R.id.album_album_name);
            artistName = (TextView) itemView.findViewById(R.id.album_album_artist);

            itemView.setOnClickListener(this);
        }

