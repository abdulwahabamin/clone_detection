    public static List<SearchResult> getAllSearchResults(Context context) {
        List<SearchResult> results = new ArrayList<>();
        List<Artist> artists = allArtists(context);
        for (Artist artist : artists) {
            results.add(createSearchResult(artist.getId(), artist.getArtistName(), artist.getAlbums().size() + " albums", SearchResult.ResultType.ARTIST));
            for (Album album : artist.getAlbums()) {
                results.add(createSearchResult(album.getId(), album.getAlbumTitle(), artist.getArtistName(), SearchResult.ResultType.ALBUM));
                for (Song song : album.getSongs()) {
                    results.add(createSearchResult(song.getId(), song.getSongTitle(),
                            artist.getArtistName() + " - " + album.getAlbumTitle()
                            , SearchResult.ResultType.SONG));
                }
            }
        }
        Collections.sort(results, new Comparator<SearchResult>() {
            @Override
            public int compare(SearchResult lhs, SearchResult rhs) {
                return lhs.getResultType().compareTo(rhs.getResultType());
            }
        });
        int lastIndexOfArtists = 0;
        int lastIndexOfAlbums = 0;
        SearchResult.ResultType resultType;
        for (int i = 0; i < results.size(); i++) {
            resultType = results.get(i).getResultType();
            if (resultType == SearchResult.ResultType.ARTIST) {
                lastIndexOfArtists = i;
            } else if (resultType == SearchResult.ResultType.ALBUM) {
                lastIndexOfAlbums = i;
            }
        }
        if (results.size() > 0) {
            results.add(0, createSearchResult(null, "Artists", null, SearchResult.ResultType.HEADER));
            results.add(lastIndexOfArtists + 2, createSearchResult(null, "Albums", null, SearchResult.ResultType.HEADER));
            results.add(lastIndexOfAlbums + 3, createSearchResult(null, "Songs", null, SearchResult.ResultType.HEADER));
            return results;
        } else {
            return null;
        }
    }

