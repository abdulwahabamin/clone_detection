    /**
     * Method that creates the standard input thread for read program response.
     *
     * @param in The standard input buffer
     * @return Thread The standard input thread
     */
    private Thread createStdInThread(final InputStream in) {
        Thread t = new Thread(new Runnable() {
            @SuppressWarnings("synthetic-access")
            @Override
            public void run() {
                final ShellConsole shell = ShellConsole.this;
                int read = 0;
                ByteArrayOutputStream sb = null;
                try {
                    while (shell.mActive) {
                        //Read only one byte with active wait
                        final int r = in.read();
                        if (r == -1) {
                            break;
                        }

                        // Type of command
                        boolean async =
                                shell.mActiveCommand != null &&
                                shell.mActiveCommand instanceof AsyncResultProgram;
                        if (!async || sb == null) {
                            sb = new ByteArrayOutputStream();
                        }

                        if (!shell.mCancelled) {
                            shell.mSbIn.write(r);
                            if (!shell.mStarted) {
                                shell.mStarted = isCommandStarted(shell.mSbIn);
                                if (shell.mStarted) {
                                    byte[] bytes = shell.mSbIn.toByteArray();
                                    sb = new ByteArrayOutputStream();
                                    sb.write(bytes, 0, bytes.length);
                                    if (async) {
                                        synchronized (shell.mPartialSync) {
                                            ((AsyncResultProgram)
                                                    shell.mActiveCommand).
                                                    onRequestStartParsePartialResult();
                                        }
                                    }
                                } else {
                                    byte[] data = shell.mSbIn.toByteArray();
                                    sb.write(data, 0, data.length);
                                }
                            } else {
                                sb.write(r);
                            }

                            // New data received
                            onNewData();

                            //Check if the command has finished (and extract the control)
                            boolean finished = isCommandFinished(shell.mSbIn, sb);

                            //Notify asynchronous partial data
                            if (shell.mStarted && async) {
                                AsyncResultProgram program =
                                        ((AsyncResultProgram)shell.mActiveCommand);
                                String partial = sb.toString();
                                if (partial.length() >= shell.mControlPattern
                                        .getEndControlPatternLength()) {
                                    program.onRequestParsePartialResult(sb.toByteArray());
                                    shell.toStdIn(partial);

                                    // Reset the temp buffer
                                    sb = new ByteArrayOutputStream();
                                }
                            }

                            if (finished) {
                                if (!async) {
                                    shell.toStdIn(String.valueOf((char)r));
                                } else {
                                    AsyncResultProgram program =
                                            ((AsyncResultProgram)shell.mActiveCommand);
                                    String partial = sb.toString();
                                    if (program != null) {
                                        program.onRequestParsePartialResult(sb.toByteArray());
                                    }
                                    shell.toStdIn(partial);
                                }

                                //Notify the end
                                notifyProcessFinished();
                                break;
                            }
                            if (!async && !finished) {
                                shell.toStdIn(String.valueOf((char)r));
                            }
                        }

                        //Has more data? Read with available as more as exists
                        //or maximum loop count is rebased
                        int count = 0;
                        while (in.available() > 0 && count < 10) {
                            count++;
                            int available =
                                    Math.min(in.available(), shell.mBufferSize);
                            byte[] data = new byte[available];
                            read = in.read(data);

                            // Type of command
                            async =
                                    shell.mActiveCommand != null &&
                                    shell.mActiveCommand instanceof AsyncResultProgram;

                            // Exit if active command is cancelled
                            if (shell.mCancelled) continue;

                            final String s = new String(data, 0, read);
                            shell.mSbIn.write(data, 0, read);
                            if (!shell.mStarted) {
                                shell.mStarted = isCommandStarted(shell.mSbIn);
                                if (shell.mStarted) {
                                    byte[] bytes = shell.mSbIn.toByteArray();
                                    sb = new ByteArrayOutputStream();
                                    sb.write(bytes, 0, bytes.length);
                                    if (async) {
                                        synchronized (shell.mPartialSync) {
                                            AsyncResultProgram p =
                                                    ((AsyncResultProgram)shell.mActiveCommand);
                                            if (p != null) {
                                                p.onRequestStartParsePartialResult();
                                            }
                                        }
                                    }
                                } else {
                                    byte[] bytes = shell.mSbIn.toByteArray();
                                    sb.write(bytes, 0, bytes.length);
                                }
                            } else {
                                sb.write(data, 0, read);
                            }

                            // New data received
                            onNewData();

                            //Check if the command has finished (and extract the control)
                            boolean finished = isCommandFinished(shell.mSbIn, sb);

                            //Notify asynchronous partial data
                            if (async) {
                                AsyncResultProgram program = ((AsyncResultProgram)shell.mActiveCommand);
                                String partial = sb.toString();
                                if (partial.length() >=  shell.mControlPattern
                                        .getEndControlPatternLength()) {
                                    if (program != null) {
                                        program.onRequestParsePartialResult(sb.toByteArray());
                                    }
                                    shell.toStdIn(partial);

                                    // Reset the temp buffer
                                    sb = new ByteArrayOutputStream();
                                }
                            }

                            if (finished) {
                                if (!async) {
                                    shell.toStdIn(s);
                                } else {
                                    AsyncResultProgram program =
                                            ((AsyncResultProgram)shell.mActiveCommand);
                                    String partial = sb.toString();
                                    if (program != null) {
                                        program.onRequestParsePartialResult(sb.toByteArray());
                                    }
                                    shell.toStdIn(partial);
                                }

                                //Notify the end
                                notifyProcessFinished();
                                break;
                            }
                            if (!async && !finished) {
                                shell.toStdIn(s);
                            }

                            //Wait for buffer to be filled
                            try {
                                Thread.sleep(1L);
                            } catch (Throwable ex) {/**NON BLOCK**/}
                        }

                        //Asynchronous programs can cause a lot of output, control buffers
                        //for a low memory footprint
                        if (async) {
                            trimBuffer(shell.mSbIn);
                            trimBuffer(shell.mSbErr);
                        }

                        //Check if process has exited
                        checkIfProcessExits();
                    }
                } catch (Exception ioEx) {
                    notifyProcessExit(ioEx);
                }
            }
        });
        t.setName(String.format("%s", "stdin")); //$NON-NLS-1$//$NON-NLS-2$
        t.start();
        return t;
    }

