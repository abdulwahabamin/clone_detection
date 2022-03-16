   /**
    * Method that creates a symlink of an other file system object.
    *
    * @param context The current context (needed if console == null)
    * @param src The absolute path to the source fso
    * @param link The absolute path to the link fso
    * @param console The console in which execute the program. <code>null</code>
    * to attach to the default console
    * @return boolean The operation result
    * @throws FileNotFoundException If the initial directory not exists
    * @throws IOException If initial directory couldn't be checked
    * @throws InvalidCommandDefinitionException If the command has an invalid definition
    * @throws NoSuchFileOrDirectory If the file or directory was not found
    * @throws ConsoleAllocException If the console can't be allocated
    * @throws InsufficientPermissionsException If an operation requires elevated permissions
    * @throws CommandNotFoundException If the command was not found
    * @throws OperationTimeoutException If the operation exceeded the maximum time of wait
    * @throws ExecutionException If the operation returns a invalid exit code
    * @throws ReadOnlyFilesystemException If the operation writes in a read-only filesystem
    * @throws CancelledOperationException If the operation was cancelled
    * @see LinkExecutable
    */
   public static boolean createLink(Context context, String src, String link, Console console)
           throws FileNotFoundException, IOException, ConsoleAllocException,
           NoSuchFileOrDirectory, InsufficientPermissionsException,
           CommandNotFoundException, OperationTimeoutException,
           ExecutionException, InvalidCommandDefinitionException, ReadOnlyFilesystemException,
           CancelledOperationException {
       Console c = ensureConsole(context, console);
       LinkExecutable executable =
               c.getExecutableFactory().newCreator().createLinkExecutable(src, link);
       writableExecute(context, executable, c);
       return executable.getResult().booleanValue();
   }

