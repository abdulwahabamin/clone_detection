        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final DocumentsActivity activity = DocumentsActivity.get(RootsFragment.this);
            final Item item = mAdapter.getItem(position);
            if (item instanceof RootItem) {
                activity.onRootPicked(((RootItem) item).root, true);
            } else if (item instanceof AppItem) {
                activity.onAppPicked(((AppItem) item).info);
            } else {
                throw new IllegalStateException("Unknown root: " + item);
            }
        }

