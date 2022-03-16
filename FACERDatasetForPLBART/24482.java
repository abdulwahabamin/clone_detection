        public int getPositionForSection(int section) {
            if (indexer != null) {
                return indexer.getPositionForSection(section);
            } else {
                return 0;
            }
        }

