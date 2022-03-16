	public Song getPrevious() {
		if (!playQueue.isEmpty()) {
			synchronized (this) {
				decrementIndex();
			}
			return playQueue.get(index);
		}
		return null;
	}

