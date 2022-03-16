    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(_id);
        dest.writeString(filePath);
        dest.writeString(title);
        dest.writeString(album);
        dest.writeLong(albumId);
        dest.writeString(albumArt);
        dest.writeString(artist);
        dest.writeLong(artistId);
        dest.writeLong(duration);
        dest.writeString(libraryUsername);
    }

