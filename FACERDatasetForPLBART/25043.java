        @Override
        public void onClick(View v) {
            List<SongDTO> singleList = new ArrayList<>(Collections.singletonList(
                    DTOConverter.getSongDTO(MusicDataUtility.getSongById(
                            currentSearchResults.get(getLayoutPosition()).getId(), v.getContext()))
            ));

            Intent playerActivity = new Intent(v.getContext(), SwipePlayerActivity.class);
            playerActivity.putParcelableArrayListExtra(SwipePlayerActivity.SONGS_PARAM,
                    (ArrayList<? extends Parcelable>) singleList);
            playerActivity.putExtra(SwipePlayerActivity.SONG_POSITION_PARAM, 0);
            v.getContext().startActivity(playerActivity);
        }

