    public ScrobbleQuery(String in) {
        String[] arr = in.split(",");
        try {
            this.mArtist = URLDecoder.decode(arr[0], "UTF-8");
            this.mTrack = URLDecoder.decode(arr[1], "UTF-8");
            this.mTimestamp = Long.parseLong(arr[2], 16);
        } catch (UnsupportedEncodingException ignored) {
        }
    }

