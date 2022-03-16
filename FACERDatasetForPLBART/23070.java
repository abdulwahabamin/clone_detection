	private int getClosestFreqToAvailable(int frequency) {
		List<Integer> availableFrequencies = getAvailableFrequencies();
		if (availableFrequencies == null)
			return -1;
		else {
			if (!availableFrequencies.contains(frequency)) {
				int frq = 0;
				int diff = 0;
				int minDiff = Math.abs(availableFrequencies.get(0) - frequency);
				int closestFreq = availableFrequencies.get(0);
				for (int i = 1; i < availableFrequencies.size(); i++) {
					frq = availableFrequencies.get(i);
					diff = Math.abs(frq - frequency);
					if (diff < minDiff) {
						closestFreq = frq;
						minDiff = diff;
					}
				}
				return closestFreq;
			}
			return frequency;
		}

	}

