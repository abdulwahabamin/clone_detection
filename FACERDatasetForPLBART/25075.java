    public static SongDTO getSongDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongTitle(song.getSongTitle());
        songDTO.setSongDuration(song.getSongDuration());
        songDTO.setSongLocation(song.getSongLocation());
        songDTO.setAlbumId(song.getAlbumId());
        songDTO.setId(song.getId());
        return songDTO;
    }

