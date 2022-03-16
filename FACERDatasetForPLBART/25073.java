    private static AlbumDTO getAlbumDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setAlbumTitle(album.getAlbumTitle());
        albumDTO.setCoverPath(album.getCoverPath());
        albumDTO.setSongs(getSongList(album.getSongs()));
        albumDTO.setId(album.getId());
        albumDTO.setArtistId(album.getId());
        return albumDTO;
    }

