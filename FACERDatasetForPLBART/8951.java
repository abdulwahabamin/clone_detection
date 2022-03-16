    /**
     * Method that returns the exit code command info.
     *
     * @param resources The application resource manager
     * @return String The exit code command info
     * @throws InvalidCommandDefinitionException If the command is not present or has an
     * invalid definition
     */
    public static synchronized String getStartCodeCommandInfo(
            Resources resources) throws InvalidCommandDefinitionException {
        //Singleton
        if (sStartCodeCmd != null) {
            return new String(sStartCodeCmd);
        }

        //Read the command list xml file
        XmlResourceParser parser = resources.getXml(R.xml.command_list);

        try {
            //Find the root element
            XmlUtils.beginDocument(parser, TAG_COMMAND_LIST);
            while (true) {
                XmlUtils.nextElement(parser);
                String element = parser.getName();
                if (element == null) {
                    break;
                }

                if (TAG_STARTCODE.equals(element)) {
                    CharSequence path = parser.getAttributeValue(R.styleable.Command_commandPath);
                    if (path == null) {
                        throw new InvalidCommandDefinitionException(
                                TAG_STARTCODE + ": path is null"); //$NON-NLS-1$
                    }

                    //Save paths
                    sStartCodeCmd = path.toString();
                    return new String(sStartCodeCmd);
                }
            }
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            parser.close();
        }

        //Command not found
        throw new InvalidCommandDefinitionException(TAG_STARTCODE);
    }

