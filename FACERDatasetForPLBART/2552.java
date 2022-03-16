	public List<Integer> getCurrentCheckedPositions() {
		List<Integer> current = new ArrayList<Integer>();
		for (int i = 0; i < mSelection.size(); i++) {
			current.add(mSelection.keyAt(i));
		}
		return current;
	}

