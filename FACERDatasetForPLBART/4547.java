		private void buildList() {
			files.clear();
			for(int i=0; i<fm.getCurrentCount(); i++) {
				files.add((FileItemZip)fm.getDirectoryItem(i));
			}
		}

