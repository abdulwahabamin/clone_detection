    public void setShuffleSeed( long seed ) {
        shuffleSeed = seed;
        lastShuffleSeed = seed;

        if (songs != null) {
            songOrder = genPlayOrder(songs.size());
            shuffleSeed = seed;
            lastShuffleSeed = seed;
        }

        // Generate new random album order
        if (albums != null) {
            albumOrder = genPlayOrder(albums.size());
            shuffleSeed = seed;
            lastShuffleSeed = seed;
        }
    }

