    @Override
    public synchronized void retrieveMedia() {
        Log.d(TAG, "retrieveMedia:called");
        try {
            if (mCurrentState == MusicProvider.State.NON_INITIALIZED) {
                mCurrentState = MusicProvider.State.INITIALIZING;

                Iterator<MediaMetadataCompat> allSongsIterator = mSource.getAllSongsIterator();
                Iterator<MediaMetadataCompat> albumsIterator = mSource.getAlbumsIterator();
                Iterator<MediaMetadataCompat> artistsIterator = mSource.getArtistsIterator();

                // making music caches

                // albumlistbykey has to be formed before making allsongs list
                // album art from this list is used for making song lists
                while (albumsIterator.hasNext()) {
                    MediaMetadataCompat item = albumsIterator.next();
                    mAlbumListByKey.put(
                            item.getString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY),
                            item
                    );
                }

                while (allSongsIterator.hasNext()) {
                    MediaMetadataCompat item = allSongsIterator.next();
                    String musicId = item.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);

                    //setting album art to the song
                    item = setAlbumArt(item);

                    mMusicListById.put(musicId, item);

                    // adding the current song to its album cache
                    String albumKey = item
                            .getString(MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY);
                    String artistKey = item
                            .getString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY);
                    if (!mMusicListByAlbumKey.containsKey(albumKey)) {
                        mMusicListByAlbumKey.put(albumKey, new ArrayList<MediaMetadataCompat>());
                    }
                    mMusicListByAlbumKey.get(albumKey).add(item);

                    String albumArtUri =
                            item.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI);

                    if (albumArtUri != null) {
                        if (!mArtistArtByKey.containsKey(artistKey)) {
                            mArtistArtByKey.put(artistKey, albumArtUri);
                        }
                    }

                    // adding current song to its artist cache
                    if (!mMusicListByArtistKey.containsKey(artistKey)) {
                        mMusicListByArtistKey.put(artistKey, new ArrayList<MediaMetadataCompat>());
                    }
                    mMusicListByArtistKey.get(artistKey).add(item);
                }

                // forming artist cache
                while (artistsIterator.hasNext()) {
                    MediaMetadataCompat item = artistsIterator.next();
                    mArtistListByKey.put(
                            item.getString(MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY),
                            setAlbumArtForArtist(item)
                    );
                }

                // initializing <all> lists cache
                allSongs = new ArrayList<>(mMusicListById.values());
                allAlbums = new ArrayList<>(mAlbumListByKey.values());
                allArtists = new ArrayList<>(mArtistListByKey.values());

                // sorting all the <all> lists according to their display title
                MediaListHelper.sortByTitle(allSongs);
                MediaListHelper.sortByTitle(allAlbums);
                MediaListHelper.sortByTitle(allArtists);

                mCurrentState = MusicProvider.State.INITIALIZED;
            }
        } catch (Exception e) {
            Log.e(TAG, "retrieveMedia:", e);
            e.printStackTrace();
        } finally {
            if (mCurrentState != MusicProvider.State.INITIALIZED) {
                Log.w(TAG, "retrieveMedia:state is not initialized");
                // setting state to non-initialized to allow retires
                // if something bad happened
                mCurrentState = MusicProvider.State.NON_INITIALIZED;
            }
        }
    }

