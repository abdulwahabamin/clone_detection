    /**
     * Method that loads the resource command list xml and
     * inflate the internal variables.
     *
     * @param resources The application resource manager
     * @throws InvalidCommandDefinitionException If the command has an invalid definition
     */
    private void getCommandInfo(Resources resources) throws InvalidCommandDefinitionException {

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

                if (TAG_COMMAND.equals(element)) {
                    CharSequence id = parser.getAttributeValue(R.styleable.Command_commandId);
                    if (id != null && id.toString().compareTo(this.mId) == 0) {
                        CharSequence path =
                                parser.getAttributeValue(R.styleable.Command_commandPath);
                        CharSequence args =
                                parser.getAttributeValue(R.styleable.Command_commandArgs);
                        if (path == null) {
                            throw new InvalidCommandDefinitionException(
                                    this.mId + ": path is null"); //$NON-NLS-1$
                        }
                        if (args == null) {
                            throw new InvalidCommandDefinitionException(
                                    this.mId + ": args is null"); //$NON-NLS-1$
                        }

                        //Save paths
                        this.mCmd = path.toString();
                        this.mArgs = args.toString();
                        //Format the arguments of the process with the command arguments
                        if (this.mArgs != null && this.mArgs.length() > 0
                                && this.mCmdArgs != null && this.mCmdArgs.length > 0) {
                            this.mArgs = String.format(this.mArgs, this.mCmdArgs);
                        }

                        return;
                    }
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
        throw new InvalidCommandDefinitionException(this.mId);
    }

