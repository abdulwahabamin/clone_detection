    /**
     * Method that creates the standard error thread for read program response.
     *
     * @param err The standard error buffer
     * @return Thread The standard error thread
     */
    private Thread createStdErrThread(final InputStream err) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                final ShellConsole shell = ShellConsole.this;
                int read = 0;
                try {
                    while (shell.mActive) {
                        //Read only one byte with active wait
                        int r = err.read();
                        if (r == -1) {
                            break;
                        }

                        // Has the process received something that we dont expect?
                        if (shell.mActiveCommand != null &&
                            shell.mActiveCommand.isExitOnStdErrOutput()) {
                            notifyProcessFinished();
                            continue;
                        }

                        // Type of command
                        boolean async =
                                shell.mActiveCommand != null &&
                                shell.mActiveCommand instanceof AsyncResultProgram;

                        ByteArrayOutputStream sb = new ByteArrayOutputStream();
                        if (!shell.mCancelled) {
                            shell.mSbErr.write(r);
                            sb.write(r);

                            //Notify asynchronous partial data
                            if (shell.mStarted && async) {
                                AsyncResultProgram program =
                                        ((AsyncResultProgram)shell.mActiveCommand);
                                if (program != null) {
                                    program.parsePartialErrResult(new String(new char[]{(char)r}));
                                }
                            }

                            toStdErr(sb.toString());
                        }

                        // New data received
                        onNewData();

                        //Has more data? Read with available as more as exists
                        //or maximum loop count is rebased
                        int count = 0;
                        while (err.available() > 0 && count < 10) {
                            count++;
                            int available = Math.min(err.available(), shell.mBufferSize);
                            byte[] data = new byte[available];
                            read = err.read(data);

                            // Type of command
                            async =
                                    shell.mActiveCommand != null &&
                                    shell.mActiveCommand instanceof AsyncResultProgram;

                            // Add to stderr
                            String s = new String(data, 0, read);
                            shell.mSbErr.write(data, 0, read);
                            sb.write(data, 0, read);

                            //Notify asynchronous partial data
                            if (async) {
                                AsyncResultProgram program =
                                        ((AsyncResultProgram)shell.mActiveCommand);
                                if (program != null) {
                                    program.parsePartialErrResult(s);
                                }
                            }
                            toStdErr(s);

                            // Has the process received something that we dont expect?
                            if (shell.mActiveCommand != null &&
                                shell.mActiveCommand.isExitOnStdErrOutput()) {
                                notifyProcessFinished();
                                break;
                            }

                            // New data received
                            onNewData();

                            //Wait for buffer to be filled
                            try {
                                Thread.sleep(1L);
                            } catch (Throwable ex) {
                                /**NON BLOCK**/
                            }
                        }

                        //Asynchronous programs can cause a lot of output, control buffers
                        //for a low memory footprint
                        if (shell.mActiveCommand != null &&
                                shell.mActiveCommand instanceof AsyncResultProgram) {
                            trimBuffer(shell.mSbIn);
                            trimBuffer(shell.mSbErr);
                        }
                    }
                } catch (Exception ioEx) {
                    notifyProcessExit(ioEx);
                }
            }
        });
        t.setName(String.format("%s", "stderr")); //$NON-NLS-1$//$NON-NLS-2$
        t.start();
        return t;
    }

