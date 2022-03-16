        @Override
        public Artist createItemFromElement(DomElement element) {
            Artist artist = new Artist(null, null);
            MusicEntry.loadStandardInfo(artist, element);
            return artist;
        }

