    private static String[] collectScanPaths(final Context context, String path) {
        ArrayList<String> paths = new ArrayList<>();
        Stack<FileSystemObject> pathsToScan = new Stack<>();
        try {
            FileSystemObject fso = getFileInfo(context, path, null);
            if (fso == null) {
                return new String[0];
            }
            pathsToScan.push(fso);
            while (!pathsToScan.isEmpty()) {
                fso = pathsToScan.pop();
                paths.add(MediaHelper.normalizeMediaPath(fso.getFullPath()));
                if (fso instanceof Directory) {
                    List<FileSystemObject> files =
                            CommandHelper.listFiles(context, fso.getFullPath(), null);
                    if (files == null) {
                        continue;
                    }
                    for (FileSystemObject file : files) {
                        if (file instanceof ParentDirectory) {
                            continue;
                        }
                        pathsToScan.push(file);
                    }
                }
            }
            return paths.toArray(new String[paths.size()]);
        } catch (IOException
                | ConsoleAllocException
                | NoSuchFileOrDirectory
                | InsufficientPermissionsException
                | CommandNotFoundException
                | OperationTimeoutException
                | ExecutionException
                | InvalidCommandDefinitionException e) {
            // Just stop scanning
            Log.e(TAG, "Recursive Delete Failed with: ", e);
            return new String[0];
        }
    }

