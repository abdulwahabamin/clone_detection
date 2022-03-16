    public static String getLyrics(File file) {
        String filename = file.getName();
        String fileending = filename.substring(filename.lastIndexOf('.') + 1, filename.length()).toLowerCase();
        try {
            switch (fileending) {
                case "mp3":
                    return getLyricsID3(file);
                case "mp4":
                case "m4a":
                case "aac":
                    return getLyricsMP4(file);
                case "ogg":
                case "oga":
                    return getLyricsVorbis(file);
            }
        } catch (Exception e) {
        }
        return null;
    }

