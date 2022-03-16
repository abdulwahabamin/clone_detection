        /**
         * {@inheritDoc}
         */
        @Override
        @SuppressWarnings("unchecked")
        public void onConcurrentPartialResult(final Object partialResults) {
            //Saved in the global result list, for save at the end
            if (partialResults instanceof FileSystemObject) {
                FileSystemObject fso = (FileSystemObject) partialResults;
                if (mMimeTypeCategories == null || mMimeTypeCategories.contains(MimeTypeHelper
                        .getCategory(SearchActivity.this, fso))) {
                    SearchActivity.this.mResultList.add((FileSystemObject) partialResults);
                    showSearchResult((FileSystemObject) partialResults);
                }
            } else {
                List<FileSystemObject> fsoList = (List<FileSystemObject>) partialResults;
                for (FileSystemObject fso : fsoList) {
                    if (mMimeTypeCategories == null || mMimeTypeCategories.contains(MimeTypeHelper
                            .getCategory(SearchActivity.this, fso))) {
                        SearchActivity.this.mResultList.add(fso);
                        showSearchResult(fso);
                    }
                }
            }
        }

