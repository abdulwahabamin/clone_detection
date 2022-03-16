    private Genre getGenreByName(String name) {
        Log.d(TAG, "getGenreByName('" + name + "') Entry.");
        if ((genres == null) || genres.isEmpty()) {
            Log.d(TAG, "getGenreByName(): Genre list null or empty.");
            return null;
        }

        if ((name == null) || name.isEmpty()) {
            Log.d(TAG, "getGenreByName(): Requested name is null or empty");
            return genres.get(0);
        }

        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).getName().equals(name)) {
                Log.d(TAG, "getGenreByName('" + name + "') is index " + i);
                return genres.get(i);
            }
        }

        Log.d(TAG, "getGenreByName('" + name + "'): No match for genre name.");
        return genres.get(0);
    }

