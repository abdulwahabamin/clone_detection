    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the array
        this.mMountPoints.clear();

        // Check the in buffer to extract information
        BufferedReader br = null;
        int line = 0;
        try {
            br = new BufferedReader(new StringReader(in));
            String szLine = null;
            while ((szLine = br.readLine()) != null) {
                //Checks that there is some text in the line. Otherwise ignore it
                if (szLine.trim().length() == 0) {
                    break;
                }

                //Parse the line into a MountPoint reference
                try {
                    this.mMountPoints.add(ParseHelper.toMountPoint(szLine));
                } catch (ParseException pEx) {
                    //Ignore
                }

                line++;
            }

        } catch (IOException ioEx) {
            throw new ParseException(ioEx.getMessage(), line);

        } catch (Exception ex) {
            throw new ParseException(ex.getMessage(), line);

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

