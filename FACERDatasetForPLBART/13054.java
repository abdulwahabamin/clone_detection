                            @Override
                            @SuppressWarnings("unqualified-field-access")
                            protected void onPostExecute(Boolean result) {
                                if (!result.booleanValue()) {
                                    return;
                                }
                                onPostExecuteTask(
                                        mTaskFiles, mAddToHistory, mIsNewHistory, mHasChanged,
                                        mSearchInfo, mNewDirChecked, mScrollTo);
                            }

