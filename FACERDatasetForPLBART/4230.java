		public static Comparator<IndexerFile> decending(final Comparator<IndexerFile> other) {
			return new Comparator<IndexerFile>() {
				public int compare(IndexerFile o1, IndexerFile o2) {
					return -1 * other.compare(o1, o2);
				}
			};
		}

