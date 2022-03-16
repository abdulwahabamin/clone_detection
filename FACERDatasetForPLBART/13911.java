    @Override
    public int compare(Music music1, Music music2) {
        return music2.getSize() < music1.getSize() ? -1
                : music2.getSize() > music1.getSize() ? 1
                : 0;
    }

