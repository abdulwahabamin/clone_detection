    public void toggleFavorite() {
        if (!isFavorite()) {
            addToFavorites();
        } else {
            removeFromFavorites();
        }
    }

