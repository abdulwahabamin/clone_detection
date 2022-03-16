    public static List<SongDTO> getSongList(List<Song> songs) {
        List<SongDTO> songDTOs = new ArrayList<>();
        for (Song song : songs) {
            songDTOs.add(getSongDTO(song));
        }
        return songDTOs;
    }

