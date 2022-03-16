    /**
     * {@inheritDoc}
     */
    @Override
    public void onParsePartialResult(byte[] in) {
        String partialIn = new String(in);

        // Check the in buffer to extract information
        final List<FileSystemObject> partialFiles = new ArrayList<FileSystemObject>();
        BufferedReader br = null;
        try {
            //Read the partial + previous partial and clean partial
            br = new BufferedReader(new StringReader(partialIn));

            //Add all lines to an array
            String line = null;
            while ((line = br.readLine()) != null) {
                //Checks that there is some text in the line. Otherwise ignore it
                if (line.trim().length() == 0) {
                    break;
                }

                // Add to the list
                try {
                    FileSystemObject fso = ParseHelper.parseStatOutput(line);

                    // Search directory is not part of the search
                    if (fso.getFullPath().compareTo(this.mDirectory.getAbsolutePath()) != 0) {
                        partialFiles.add(fso);
                    }

                } catch (Exception e) {
                    // Log the parsing error
                    if (isTrace()) {
                        Log.w(TAG,
                            String.format(
                                    "Failed to parse output: %s", //$NON-NLS-1$
                                    String.valueOf(line)));
                    }
                }
            }

            //If a listener is defined, then send the partial result
            if (getAsyncResultListener() != null) {
                getAsyncResultListener().onPartialResult(partialFiles);
            }

        } catch (Exception ex) {
            Log.w(TAG, "Partial result fails", ex); //$NON-NLS-1$

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

