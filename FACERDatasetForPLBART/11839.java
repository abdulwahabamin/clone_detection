    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the array
        this.mFiles.clear();

        // Read every line and parse it
        BufferedReader br = null;
        try {
            br = new BufferedReader(new StringReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                //Checks that there is some text in the line. Otherwise ignore it
                if (line.trim().length() == 0) {
                    break;
                }

                // Parse and add to result files
                try {
                    this.mFiles.add(ParseHelper.parseStatOutput(line));
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

            // Add the parent directory
            if (this.mParentDir != null &&
                    this.mParentDir.compareTo(FileHelper.ROOT_DIRECTORY) != 0 &&
                    this.mMode.compareTo(LIST_MODE.DIRECTORY) == 0) {
                this.mFiles.add(0, new ParentDirectory(new File(this.mParentDir).getParent()));
            }

        } catch (IOException ioEx) {
            throw new ParseException(ioEx.getMessage(), 0);

        } catch (Exception ex) {
            throw new ParseException(ex.getMessage(), 0);

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

