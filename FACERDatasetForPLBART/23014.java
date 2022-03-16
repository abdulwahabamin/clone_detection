	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(title);
		out.writeString(key);
		out.writeString(artist);
		out.writeInt(numSongs);
	}

