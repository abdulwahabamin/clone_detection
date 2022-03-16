        @Override
        protected Boolean doInBackground(Boolean... params) {
            IndexerDb.init(getActivity());
            items = IndexerDb.getDb().getImageVideoItems(0, 10);
//Log.e("ITEMSSIZE","ITEMS SIZE : "+items.size());

            return Boolean.TRUE;

        }

