    private static List<AlbumDTO> getAlbumList(List<Album> albums) {
        List<AlbumDTO> albumDTOs = new ArrayList<>();
        for (Album album : albums) {
            albumDTOs.add(getAlbumDTO(album));
        }
        return albumDTOs;
    }

