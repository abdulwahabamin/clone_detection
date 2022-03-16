    /**
     * Read a file as hex document
     *
     * @param ctx The current context
     * @param document The document to read
     * @param lines The internal output
     * @return output The output
     */
    private static List<String> readHexDumpDocumentFile(Context ctx, FileSystemObject document,
            List<String> lines) {
        InputStream is = null;
        ByteArrayOutputStream baos;
        AsyncDocumentReader reader = null;
        try {
            // Async read the document while blocking with a buffered stream
            reader = new AsyncDocumentReader(ctx);
            CommandHelper.read(ctx, document.getFullPath(), reader, null);

            int bufferSize = ctx.getResources().getInteger(R.integer.buffer_size);
            baos = new ByteArrayOutputStream();
            is = new BufferedInputStream(reader.mIn);

            byte[] data = new byte[bufferSize];
            int read = 0;
            while((read = is.read(data, 0, bufferSize)) != -1) {
                baos.write(data, 0, read);
            }

            // Got an exception?
            if (reader.mCause != null) {
                lines.clear();
                Log.e(TAG, "Failed to read file " + document.getFullPath(), reader.mCause);
            }
        } catch (Exception ex) {
            Log.e(TAG, "Failed to read file " + document.getFullPath(), ex);
            lines.clear();
            return new ArrayList<String>();
        } finally {
            if (is != null) {
                try {
                    is.close();
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

        // Convert the bytes to a hex printable string and free resources
        String documentBuffer = StringHelper.toHexPrintableString(baos.toByteArray());
        try {
            baos.close();
        } catch (IOException ex) {
            //Ignore
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new StringReader(documentBuffer));
            String line = null;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
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
        }

        // Use the final array and clear the original (we don't use it anymore)
        List<String> output = new ArrayList<String>(lines);
        lines.clear();
        return output;
    }

