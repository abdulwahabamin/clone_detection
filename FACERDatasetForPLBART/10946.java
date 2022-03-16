    /**
     * Method that does the read of the file in background
     * @hide
     */
    void asyncRead() {
        // Do the load of the file
        AsyncTask<FileSystemObject, Integer, Boolean> mReadTask =
                            new AsyncTask<FileSystemObject, Integer, Boolean>() {

            private Exception mCause;
            private AsyncReader mReader;
            private boolean changeToBinaryMode;
            private boolean changeToDisplaying;

            @Override
            protected void onPreExecute() {
                // Show the progress
                this.changeToBinaryMode = false;
                this.changeToDisplaying = false;
                doProgress(true, 0);
            }

            @Override
            protected Boolean doInBackground(FileSystemObject... params) {
                final EditorActivity activity = EditorActivity.this;

                // Only one argument (the file to open)
                FileSystemObject fso = params[0];
                this.mCause = null;

                // Read the file in an async listener
                try {
                    while (true) {
                        // Configure the reader
                        this.mReader = new AsyncReader(true);
                        this.mReader.mReadFso = fso;
                        this.mReader.mListener = new OnProgressListener() {
                            @Override
                            @SuppressWarnings("synthetic-access")
                            public void onProgress(int progress) {
                                publishProgress(Integer.valueOf(progress));
                            }
                        };

                        // Execute the command (read the file)
                        CommandHelper.read(activity, fso.getFullPath(), this.mReader,
                                           null);

                        // Wait for
                        synchronized (this.mReader.mSync) {
                            while (!this.mReader.mReadDoneLocked) {
                                this.mReader.mSync.wait();
                            }
                        }

                        // 100%
                        publishProgress(new Integer(100));

                        // Check if the read was successfully
                        if (this.mReader.mCause != null) {
                            this.mCause = this.mReader.mCause;
                            return Boolean.FALSE;
                        }
                        break;
                    }

                    // Now we have the byte array with all the data. is a binary file?
                    // Then dump them byte array to hex dump string (only if users settings
                    // to dump file)
                    if (activity.mBinary && mHexDump) {
                        // we do not use the Hexdump helper class, because we need to show the
                        // progress of the dump process
                        final String data = toHexPrintableString(toHexDump(
                                this.mReader.mByteBuffer.toByteArray()));
                        this.mReader.mBinaryBuffer = new ArrayList<String>();
                        BufferedReader reader = new BufferedReader(new StringReader(data));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            this.mReader.mBinaryBuffer.add(line);
                        }
                        Log.i(TAG, "Bytes read: " + data.length()); //$NON-NLS-1$
                    } else {
                        String data;
                        if (this.mReader.mDetectedEncoding != null) {
                            data = new String(this.mReader.mByteBuffer.toByteArray(),
                                              this.mReader.mDetectedEncoding);
                        } else {
                            data = new String(this.mReader.mByteBuffer.toByteArray());
                        }
                        this.mReader.mBuffer = new SpannableStringBuilder(data);
                        Log.i(TAG, "Bytes read: " + data.getBytes().length); //$NON-NLS-1$
                    }
                    this.mReader.mByteBuffer = null;

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
                    if (activity.mBinary && mHexDump) {
                        HexDumpAdapter adapter = new HexDumpAdapter(EditorActivity.this,
                                this.mReader.mBinaryBuffer);
                        mBinaryEditor.setAdapter(adapter);

                        // Cleanup
                        this.mReader.mBinaryBuffer = null;
                    } else {
                        activity.mEditor.setText(
                                this.mReader.mBuffer, BufferType.EDITABLE);

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

                        //Cleanup
                        this.mReader.mBuffer = null;
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

            /**
             * Create a hex dump of the data while show progress to user
             *
             * @param data The data to hex dump
             * @return StringBuilder The hex dump buffer
             */
            private String toHexDump(byte[] data) {
                //Change to binary mode
                this.changeToBinaryMode = true;

                // Start progress
                publishProgress(Integer.valueOf(0));

                // Calculate max dir size
                int length = data.length;

                final int DISPLAY_SIZE = 16;  // Bytes per line
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                byte[] line = new byte[DISPLAY_SIZE];
                int read = 0;
                int offset = 0;
                StringBuilder sb = new StringBuilder();
                while ((read = bais.read(line, 0, DISPLAY_SIZE)) != -1) {
                    //offset   dump(16)   data\n
                    String linedata = new String(line, 0, read);
                    sb.append(HexDump.toHexString(offset));
                    sb.append(" "); //$NON-NLS-1$
                    String hexDump = HexDump.toHexString(line, 0, read);
                    if (hexDump.length() != (DISPLAY_SIZE * 2)) {
                        char[] array = new char[(DISPLAY_SIZE * 2) - hexDump.length()];
                        Arrays.fill(array, ' ');
                        hexDump += new String(array);
                    }
                    sb.append(hexDump);
                    sb.append(" "); //$NON-NLS-1$
                    sb.append(linedata);
                    sb.append(EditorActivity.this.mHexLineSeparator);
                    offset += DISPLAY_SIZE;
                    if (offset % 5 == 0) {
                        publishProgress(Integer.valueOf((offset * 100) / length));
                    }
                }

                // End of the dump process
                publishProgress(Integer.valueOf(100));

                return sb.toString();
            }

            /**
             * Method that converts to a visual printable hex string
             *
             * @param string The string to check
             */
            private String toHexPrintableString(String string) {
                // Remove characters without visual representation
                final String REPLACED_SYMBOL = "."; //$NON-NLS-1$
                final String NEWLINE = System.getProperty("line.separator"); //$NON-NLS-1$
                String printable = string.replaceAll("\\p{Cntrl}", REPLACED_SYMBOL); //$NON-NLS-1$
                printable = printable.replaceAll("[^\\p{Print}]", REPLACED_SYMBOL); //$NON-NLS-1$
                printable = printable.replaceAll("\\p{C}", REPLACED_SYMBOL); //$NON-NLS-1$
                printable = printable.replaceAll(EditorActivity.this.mHexLineSeparator, NEWLINE);
                return printable;
            }
        };
        mReadTask.execute(this.mFso);
    }

