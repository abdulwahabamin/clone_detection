    public List<MediaMetadataCompat> getAllRetrievedMusic() {
        ArrayList<MediaMetadataCompat> result = new ArrayList<>();
        for (MediaMetadataCompat track : musicList) {
            result.add(track);
        }
        return result;
    }

