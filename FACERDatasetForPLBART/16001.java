        SongHolder(View itemView) {
            super(itemView);
            this.trackView = itemView;

            trackArtist = (TextView) trackView.findViewById(R.id.trackArtist);
            trackAlbum = (TextView) trackView.findViewById(R.id.trackAlbum);
            trackTitle = (TextView) trackView.findViewById(R.id.trackTitle);
            trackAlbumArt = (ImageView) trackView.findViewById(R.id.trackAlbumArt);
            
            itemView.setOnClickListener(this);
        }

