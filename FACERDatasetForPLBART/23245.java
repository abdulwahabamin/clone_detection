    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case PLAY_SELECTION: {
                // play everything by the selected artist
                int [] list =
                    mCurrentArtistId != null ?
                    MusicUtils.getSongListForArtist(this, Integer.parseInt(mCurrentArtistId))
                    : MusicUtils.getSongListForAlbum(this, Integer.parseInt(mCurrentAlbumId));
                        
                MusicUtils.playAll(this, list, 0);
                return true;
            }

            case QUEUE: {
                int [] list =
                    mCurrentArtistId != null ?
                    MusicUtils.getSongListForArtist(this, Integer.parseInt(mCurrentArtistId))
                    : MusicUtils.getSongListForAlbum(this, Integer.parseInt(mCurrentAlbumId));
                MusicUtils.addToCurrentPlaylist(this, list);
                return true;
            }

            case NEW_PLAYLIST: {
                Intent intent = new Intent();
                intent.setClass(this, CreatePlaylist.class);
                startActivityForResult(intent, NEW_PLAYLIST);
                return true;
            }

            case PLAYLIST_SELECTED: {
                int [] list =
                    mCurrentArtistId != null ?
                    MusicUtils.getSongListForArtist(this, Integer.parseInt(mCurrentArtistId))
                    : MusicUtils.getSongListForAlbum(this, Integer.parseInt(mCurrentAlbumId));
                int playlist = item.getIntent().getIntExtra("playlist", 0);
                MusicUtils.addToPlaylist(this, list, playlist);
                return true;
            }
            
            case DELETE_ITEM: {
                int [] list;
                String desc;
                if (mCurrentArtistId != null) {
                    list = MusicUtils.getSongListForArtist(this, Integer.parseInt(mCurrentArtistId));
                    String f = getString(R.string.delete_artist_desc);
                    desc = String.format(f, mCurrentArtistName);
                } else {
                    list = MusicUtils.getSongListForAlbum(this, Integer.parseInt(mCurrentAlbumId));
                    String f = getString(R.string.delete_album_desc); 
                    desc = String.format(f, mCurrentAlbumName);
                }
                Bundle b = new Bundle();
                b.putString("description", desc);
                b.putIntArray("items", list);
                Intent intent = new Intent();
                intent.setClass(this, DeleteItems.class);
                intent.putExtras(b);
                startActivityForResult(intent, -1);
                return true;
            }
            
            case SEARCH:
                doSearch();
                return true;
        }
        return super.onContextItemSelected(item);
    }

