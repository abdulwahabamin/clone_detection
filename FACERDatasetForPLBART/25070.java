    public static List<ArtistDTO> getArtistList(List<Artist> artists) {
        List<ArtistDTO> artistDTOs = new ArrayList<>();
        for (Artist artist : artists) {
            artistDTOs.add(getArtistDTO(artist));
        }
        return artistDTOs;
    }

