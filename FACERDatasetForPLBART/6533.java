        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final Item item = mAdapter.getItem(position);
            if (item instanceof AppItem) {
                showAppDetails(((AppItem) item).info);
                return true;
            } else {
                return false;
            }
        }

