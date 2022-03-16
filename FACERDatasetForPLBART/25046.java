        public ArtistViewHolder(View v) {
            super(v);
            artistName = (TextView) v.findViewById(R.id.txt_artist_name);
            artistDetails = (TextView) v.findViewById(R.id.txt_artist_details);
            v.setOnClickListener(this);
        }

