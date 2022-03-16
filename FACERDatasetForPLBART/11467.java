    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Getting usage from %s", //$NON-NLS-1$
                            this.mMountsFile));
        }

        // Read the file with the mount information
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(this.mMountsFile)), getBufferSize());
            StringBuilder sb = new StringBuilder();
            int read = 0;
            char[] data = new char[getBufferSize()];
            while ((read = br.read(data, 0, getBufferSize())) != -1) {
                sb.append(data, 0, read);
            }

            // Send to parse
            String[] lines = sb.toString().split("\n"); //$NON-NLS-1$
            for (int i = 0; i < lines.length; i++) {
                MountPoint mp = ParseHelper.toMountPoint(lines[i]);
                if (isTrace()) {
                    Log.v(TAG, String.valueOf(mp));
                }
                this.mMountPoints.add(mp);
            }

        } catch (Exception e) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
            }
            throw new InsufficientPermissionsException();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Throwable _throw) {/**NON BLOCK**/}
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

