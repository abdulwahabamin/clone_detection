                            @Override
                            @SuppressWarnings({
                                "unchecked", "unqualified-field-access"
                            })
                            protected Boolean doInBackground(Object... taskParams) {
                                mTaskFiles = (List<FileSystemObject>)taskParams[0];
                                return Boolean.TRUE;
                            }

