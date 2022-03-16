    public static ArtistDTO getArtistDTO(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistName(artist.getArtistName());
        artistDTO.setCoverPath(artist.getCoverPath());
        artistDTO.setAlbums(getAlbumList(artist.getAlbums()));
        artistDTO.setId(artist.getId());
        return artistDTO;
    }

