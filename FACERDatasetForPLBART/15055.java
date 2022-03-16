        @Override
        public Album createItemFromElement(DomElement element) {
            Album album = new Album(null, null, null);
            MusicEntry.loadStandardInfo(album, element);
            if (element.hasChild("artist")) {
                album.artist = element.getChild("artist").getChildText("name");
                if (album.artist == null)
                    album.artist = element.getChildText("artist");
            }
            return album;
        }

