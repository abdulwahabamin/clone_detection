    /**
     * {@inheritDoc}
     */
    @Override
    public void parse(String in, String err) throws ParseException {
        //Release the return object
        this.mIdentity = null;

        // Check the in buffer to extract information
        BufferedReader br = null;
        try {
            br = new BufferedReader(new StringReader(in));
            String szLine = br.readLine();
            if (szLine == null) {
                throw new ParseException("no information", 0); //$NON-NLS-1$
            }

            szLine = szLine.replaceAll(" ", FileHelper.NEWLINE); //$NON-NLS-1$
            Properties p = new Properties();
            p.load(new StringReader(szLine));

            //At least uid and gid must be present
            if (!p.containsKey(UID) && !p.containsKey(GID)) {
                throw new ParseException(
                        String.format(
                                "no %s or %s present in %s", UID, GID, szLine), 0); //$NON-NLS-1$
            }

            //1.- Extract user
            User user = (User)createAID(p.getProperty(UID), User.class);

            //2.- Extract group
            Group group = (Group)createAID(p.getProperty(GID), Group.class);

            //3.- Extract groups
            List<Group> groups = new ArrayList<Group>();
            String szGroups = p.getProperty(GROUPS);
            if (szGroups != null && szGroups.length() > 0) {
                String[] aGroups = szGroups.split(","); //$NON-NLS-1$
                int cc = aGroups.length;
                for (int i = 0; i < cc; i++) {
                    groups.add((Group)createAID(aGroups[i], Group.class));
                }
            }

            //Now the string is parsed into a reference
            this.mIdentity = new Identity(user, group, groups);

        } catch (IOException ioEx) {
            throw new ParseException(ioEx.getMessage(), 0);

        } catch (ParseException pEx) {
            throw pEx;

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

