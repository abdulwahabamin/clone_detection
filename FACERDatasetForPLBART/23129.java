	public Song getNext() {
		if (!playQueue.isEmpty()) {
			synchronized (this) {
				incrementIndex();
			}
			return playQueue.get(index);
		}
		return null;
	}

