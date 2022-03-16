        @Override
        protected Void doInBackground(Void... params) {
            mQuerySelection = buildQuerySelectionClause();
            mCursor = mApp.getDBAccessHelper().getFragmentCursor(mContext, mQuerySelection, mFragmentId);
            loadDBColumnNames();

            return null;
        }

