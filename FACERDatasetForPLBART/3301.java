        @Override
        protected Boolean doInBackground(Boolean... params) {
            BLog.e("RunIndexingTask activated");
            IndexerDb.init(SERVICE);
            //IndexerDb.getDb().deleteAll();
            //State.getSettings().setInt();

            Indexer.refresh(SERVICE);


            return Boolean.TRUE;

        }

