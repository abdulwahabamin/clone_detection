        @Override
        protected Boolean doInBackground(Void... params) {
            ArrayList<DocumentInfo> docs = new ArrayList<DocumentInfo>();
            Collections.addAll(docs, mDocs);
            boolean result = onDeleteDocumentsImpl(docs);

            return result;
        }

