    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the return object
        this.mGroups = new ArrayList<Group>();

        // Check the in buffer to extract information
        BufferedReader br = null;
        try {
            if (in == null) {
                return;
            }
            String szIn = in.replaceAll(" ", FileHelper.NEWLINE); //$NON-NLS-1$
            br = new BufferedReader(new StringReader(szIn));
            String szLine = null;
            while ((szLine = br.readLine()) != null) {
                this.mGroups.add(new Group(-1, szLine.trim()));
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

