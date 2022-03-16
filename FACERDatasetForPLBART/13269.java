    /**
     *
     * @param context
     * @param srcPath null or the source in which the file is being moved from
     * @param destPath the root of the path being created
     */
    private static void recursiveScan(@NonNull final Context context,
                                      @Nullable String srcPath,
                                      @NonNull String destPath,
                                      int maxDepth) {
        ArrayList<String> paths = new ArrayList<>();
        Stack<FileSystemObjectWithDepth> pathsToScan = new Stack<>();
        try {
            FileSystemObject fso = getFileInfo(context, destPath, null);
            if (fso == null) {
                return;
            }
            pathsToScan.push(new FileSystemObjectWithDepth(fso, 0));
            while (!pathsToScan.isEmpty()) {
                FileSystemObjectWithDepth fsowd = pathsToScan.pop();
                fso = fsowd.fso;
                if (srcPath != null) {
                    String src = fso.getFullPath().replace(destPath, srcPath);
                    // Add the path to be deleted
                    paths.add(MediaHelper.normalizeMediaPath(src));
                }
                // Add the path to be added
                paths.add(MediaHelper.normalizeMediaPath(fso.getFullPath()));
                if (fso instanceof Directory && (maxDepth == -1 || fsowd.depth < maxDepth)) {
                    try {
                        List<FileSystemObject> files =
                                CommandHelper.listFiles(context, fso.getFullPath(), null);

                        if (files == null) {
                            continue;
                        }
                        for (FileSystemObject file : files) {
                            if (file instanceof ParentDirectory) {
                                continue;
                            }
                            pathsToScan.push(new FileSystemObjectWithDepth(file, fsowd.depth + 1));
                        }
                    } catch (IOException
                            | ConsoleAllocException
                            | NoSuchFileOrDirectory
                            | InsufficientPermissionsException
                            | CommandNotFoundException
                            | OperationTimeoutException
                            | ExecutionException
                            | InvalidCommandDefinitionException e) {
                        // Just skip this directory
                    }
                }

                if (paths.size() > 100) {
                    MediaScannerConnection.scanFile(context, paths.toArray(new String[paths.size()]), null, null);
                    paths.clear();
                }
            }
            MediaScannerConnection.scanFile(context, paths.toArray(new String[paths.size()]), null, null);
        } catch (IOException
                | ConsoleAllocException
                | NoSuchFileOrDirectory
                | InsufficientPermissionsException
                | CommandNotFoundException
                | OperationTimeoutException
                | ExecutionException
                | InvalidCommandDefinitionException e) {
            // Just stop scanning
        }
    }

