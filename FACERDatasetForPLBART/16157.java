        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Song song = getItem(position);

            if(convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.track, parent,false);
            }

            TextView trackArtist = (TextView) convertView.findViewById(R.id.trackArtist);
            TextView trackAlbum = (TextView) convertView.findViewById(R.id.trackAlbum);
            TextView trackTitle = (TextView) convertView.findViewById(R.id.trackTitle);
            ImageView trackAlbumArt = (ImageView) convertView.findViewById(R.id.trackAlbumArt);

            trackAlbum.setText(song.getAlbum());
            String string = song.getArtist();
            if(!string.equals("<unknown>"))
                trackArtist.setText(string);
            else trackArtist.setText(R.string.track_artist);
            trackTitle.setText(song.getTitle());

            trackAlbumArt.setImageResource(R.drawable.ic_album_black_24dp);

            String path = song.getAlbumArt();
            if(path != null) {
                AsyncImageLoader.ImageLoadTask task = asyncImageLoader.loadImageAsync(trackAlbumArt, path);
                if(convertView.getTag() != null) {
                    asyncImageLoader.cancelTask((AsyncImageLoader.ImageLoadTask) convertView.getTag());
                }
                convertView.setTag(task);
                asyncImageLoader.loadAsync(task);
            }

            return convertView;
        }

