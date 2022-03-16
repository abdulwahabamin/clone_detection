		private void buildList() {
			files.clear();
			for(int i=0; i<fm.getCurrentCount(); i++) {
				files.add(fm.getDirectoryItem(i));
			}
		}

