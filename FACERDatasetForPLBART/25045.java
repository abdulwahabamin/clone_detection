        @Override
        public void onClick(View v) {
            MusicContent musicContent = new MusicContent();
            musicContent.setContentType(ContentType.ALBUM);
            musicContent.setPlaylistName(currentSearchResults.get(getLayoutPosition()).getMainTitle());
            musicContent.setId(currentSearchResults.get(getLayoutPosition()).getId());

            v.getContext().startActivity(PlaylistActivity.getIntent(v.getContext(), musicContent));
        }

