	public Collection<Song> getCollection() {
		int size = getCount();
		ArrayList<Song> list = new ArrayList<Song>(size);
		for (int i = 0; i < size; i++) {
			list.add(i, getItem(i));
		}
		return list;
	}

