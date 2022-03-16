    public static byte[] getImageData(String songLocation) {
        File songFile = new File(songLocation);
        if (songFile.exists()) {
            return new MusicMetaData(songLocation).getAlbumArt();
        }
        return null;
    }

