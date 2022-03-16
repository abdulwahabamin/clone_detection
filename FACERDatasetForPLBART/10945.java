    /**
     * Method that does the read of a content uri in the background
     * @hide
     */
    void asyncReadContentURI(Uri uri) {
        // Do the load of the file
        AsyncTask<Uri, Integer, Boolean> mReadTask =
                new AsyncTask<Uri, Integer, Boolean>() {

                    private Exception mCause;
                    private boolean changeToBinaryMode;
                    private boolean changeToDisplaying;
                    private String tempText;

                    @Override
                    protected void onPreExecute() {
                        // Show the progress
                        this.changeToBinaryMode = false;
                        this.changeToDisplaying = false;
                        doProgress(true, 0);
                    }

                    @Override
                    protected Boolean doInBackground(Uri... params) {

                        // Only one argument (the file to open)
                        Uri fso = params[0];
                        this.mCause = null;

                        // Read the file in an async listener
                        try {

                            publishProgress(Integer.valueOf(0));

                            InputStream is = getContentResolver().openInputStream(fso);

                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            int readBytes;
                            byte[] buffer = new byte[1024];
                            try {
                                while ((readBytes = is.read(buffer, 0, buffer.length)) != -1) {
                                    baos.write(buffer, 0, readBytes);
                                    publishProgress(
                                            Integer.valueOf((readBytes * 100) / buffer.length));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                return Boolean.FALSE;
                            }

                            // 100%
                            publishProgress(new Integer(100));
                            tempText = new String(baos.toByteArray(), "UTF-8");
                            Log.i(TAG, "Bytes read: " + baos.toByteArray().length); //$NON-NLS-1$

                            // 100%
                            this.changeToDisplaying = true;
                            publishProgress(new Integer(0));

                        } catch (Exception e) {
                            this.mCause = e;
                            return Boolean.FALSE;
                        }

                        return Boolean.TRUE;

                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        // Do progress
                        doProgress(true, values[0].intValue());
                    }

                    @Override
                    protected void onPostExecute(Boolean result) {
                        final EditorActivity activity = EditorActivity.this;
                        // Is error?
                        if (!result.booleanValue()) {
                            if (this.mCause != null) {
                                ExceptionUtil.translateException(activity, this.mCause);
                                activity.mEditor.setEnabled(false);
                            }
                        } else {
                            // Now we have the buffer, set the text of the editor
                            activity.mEditor.setText(
                                    tempText, BufferType.EDITABLE);

                            // Highlight editor text syntax
                            if (activity.mSyntaxHighlight &&
                                    activity.mSyntaxHighlightProcessor != null) {
                                try {
                                    activity.mSyntaxHighlightProcessor.process(
                                            activity.mEditor.getText());
                                } catch (Exception ex) {
                                    // An error in a syntax library, should not break down app.
                                    Log.e(TAG, "Syntax highlight failed.", ex); //$NON-NLS-1$
                                }
                            }

                            setDirty(false);
                            activity.mEditor.setEnabled(!activity.mReadOnly);

                            // Notify read-only mode
                            if (activity.mReadOnly) {
                                DialogHelper.showToast(
                                        activity,
                                        R.string.editor_read_only_mode,
                                        Toast.LENGTH_SHORT);
                            }
                        }

                        doProgress(false, 0);
                    }

                    @Override
                    protected void onCancelled() {
                        // Hide the progress
                        doProgress(false, 0);
                    }

                    /**
                     * Method that update the progress status
                     *
                     * @param visible If the progress bar need to be hidden
                     * @param progress The progress
                     */
                    private void doProgress(boolean visible, int progress) {
                        final EditorActivity activity = EditorActivity.this;

                        // Show the progress bar
                        activity.mProgressBar.setProgress(progress);
                        activity.mProgress.setVisibility(visible ? View.VISIBLE : View.GONE);

                        if (this.changeToBinaryMode) {
                            mWordWrapView.setVisibility(View.GONE);
                            mNoWordWrapView.setVisibility(View.GONE);
                            mBinaryEditor.setVisibility(View.VISIBLE);

                            // Show hex dumping text
                            activity.mProgressBarMsg.setText(R.string.dumping_message);
                            this.changeToBinaryMode = false;
                        }
                        else if (this.changeToDisplaying) {
                            activity.mProgressBarMsg.setText(R.string.displaying_message);
                            this.changeToDisplaying = false;
                        }
                    }
                };
        mReadTask.execute(uri);
    }

