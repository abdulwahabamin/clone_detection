    private static boolean isPlaying() {
        if (MusicUtils.sService != null) {
            return sService.isPlaying();
        }
        return false;
    }

