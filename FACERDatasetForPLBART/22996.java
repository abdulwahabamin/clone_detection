    public ArrayList<HashMap<String, String>> getPlayList() {
        try {
            File home = new File(MEDIA_PATH);
            getPlayList(home);
            return songsList;
        } catch (Exception e) {
            Log.d("",e.getLocalizedMessage());
        }
        return new ArrayList<HashMap<String, String>>();
    }

