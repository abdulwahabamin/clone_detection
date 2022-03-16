    /**
     * Method that checks if the file has a binary format
     *
     * @param ctx The current context
     * @param document The document to read
     * @return boolean If the document has a binary format
     */
    private static boolean isBinaryDocument(Context ctx, FileSystemObject document) {
        BufferedReader br = null;
        boolean binary = false;
        AsyncDocumentReader reader = null;
        try {
            reader = new AsyncDocumentReader(ctx);
            ReadExecutable command = CommandHelper.read(ctx, document.getFullPath(), reader, null);
            br = new BufferedReader(new InputStreamReader(reader.mIn));

            char[] data = new char[50];
            int read = br.read(data);
            for (int i = 0; i < read; i++) {
                if (!StringHelper.isPrintableCharacter(data[i])) {
                    binary = true;
                    break;
                }
            }
            command.cancel();

        } catch (Exception ex) {
            //Ignore
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
        return binary;
    }

