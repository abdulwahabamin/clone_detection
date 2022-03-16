        @Override
        public Cursor swapCursor(Cursor c) {
            Cursor res = super.swapCursor(c);
            if (c != null) {
                getColumnIndices(c);
            }
            return res;
        }

