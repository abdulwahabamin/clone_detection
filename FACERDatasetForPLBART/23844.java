    private int getGenreIndex(String name) {
        Log.d(TAG, "getGenreIndex('" + name + "') Entry.");
        if ((genres == null) || (genres.isEmpty()) || (name == null)) {
            Log.d(TAG, "getGenreIndex(): Genre empty or desired name is null.");
            return 0;
        }

        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).getName().equals(name)) {
                Log.d(TAG, "getGenreIndex('" + name + "') is index " + i);
                return i;
            }
        }
        Log.d(TAG, "getGenreIndex(): No match for genre name.");
        return 0;
    }

