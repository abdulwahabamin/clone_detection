    @Override
    public List<String> getPlaylistIds() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>(){}.getType();
        if (mDataManager.getPlaylistIds() != null) {
            return gson.fromJson(mDataManager.getPlaylistIds(), listType);
        }

        return null;
    }

