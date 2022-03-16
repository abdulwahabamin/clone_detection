		public static Comparator<IndexerFile> getComparator(final PersonComparator... multipleOptions) {
			return new Comparator<IndexerFile>() {
				public int compare(IndexerFile o1, IndexerFile o2) {
					for (PersonComparator option : multipleOptions) {
						int result = option.compare(o1, o2);
						if (result != 0) {
							return result;
						}
					}
					return 0;
				}
			};
		}

