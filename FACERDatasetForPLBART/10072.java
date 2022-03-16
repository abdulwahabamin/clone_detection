    /**
     * Read a file as document
     *
     * @param ctx The current context
     * @param document The document to read
     * @param lines The output
     */
    private static void readDocumentFile(Context ctx, FileSystemObject document,
            List<String> lines) {
        BufferedReader br = null;
        AsyncDocumentReader reader = null;
        try {
            // Async read the document while blocking with a buffered reader
            int bufferSize = ctx.getResources().getInteger(R.integer.buffer_size);
            reader = new AsyncDocumentReader(ctx);
            CommandHelper.read(ctx, document.getFullPath(), reader, null);
            br = new BufferedReader(new InputStreamReader(reader.mIn), bufferSize);

            String line = null;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }

            // Got an exception?
            if (reader.mCause != null) {
                lines.clear();
                Log.e(TAG, "Failed to read file " + document.getFullPath(), reader.mCause);
            }

        } catch (Exception ex) {
            lines.clear();
            Log.e(TAG, "Failed to read file " + document.getFullPath(), ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    //Ignore
                }
            }
            if (reader != null && reader.mIn != null) {
                try {
                    reader.mIn.close();
                } catch (IOException ex) {
                    //Ignore
                }
            }
            if (reader != null && reader.mFdIn != null) {
                try {
                    reader.mFdIn.close();
                } catch (IOException ex) {
                    //Ignore
                }
            }
        }
    }

