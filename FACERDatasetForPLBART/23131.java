	public Song getCurrent() {
		if (!playQueue.isEmpty()) {
			if (index >= 0) {
				return playQueue.get(index);
			} else {
				return playQueue.get(0);
			}
		}
		return null;
	}

