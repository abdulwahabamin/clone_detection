        @Override
        public Song createFromParcel(Parcel source) {
            long _id = source.readLong();
            String filePath = source.readString();
            String title = source.readString();
            String album = source.readString();
            long albumId = source.readLong();
            String albumArt  = source.readString();
            String artist = source.readString();
            long artistId = source.readLong();
            long duration = source.readLong();
            String libraryUsername = source.readString();
            return new Song(_id, filePath, title, album, albumId, albumArt, artist, artistId,duration,
                    libraryUsername);
        }

