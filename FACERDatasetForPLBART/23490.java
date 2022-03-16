        public int getPositionForSection(int section) {
            Cursor cursor = getCursor();
            if (cursor == null) {
                // No cursor, the section doesn't exist so just return 0
                return 0;
            }
            
            return mIndexer.getPositionForSection(section);
        }

