		public static Comparator<IndexerFile> ascending(final Comparator<IndexerFile> other) {
			return new Comparator<IndexerFile>() {
				public int compare(IndexerFile o1, IndexerFile o2) {
					return -1 * other.compare(o2, o1);
				}
			};
		}

