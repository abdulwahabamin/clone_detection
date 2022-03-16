    /**
     * Constructor of <code>ExecutionDialog</code>.
     *
     * @param context The current context
     * @param fso The file system object to execute
     */
    public ExecutionDialog(final Context context, final FileSystemObject fso) {
        super();

        // Limits
        this.maxLines = context.getResources().getInteger(R.integer.console_max_lines);
        this.maxChars = context.getResources().getInteger(R.integer.console_max_chars_per_line);

        //Save the context
        this.mContext = context;
        this.mFinished = false;
        this.mQueue = new FixedQueue<String>(this.maxLines);

        //Create the layout
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup layout = (ViewGroup)li.inflate(R.layout.execution_dialog, null);
        TextView tvScriptName = (TextView)layout.findViewById(R.id.execution_script_name);
        tvScriptName.setText(fso.getFullPath());
        this.mTvTime = (TextView)layout.findViewById(R.id.execution_time);
        this.mTvTime.setText("-"); //$NON-NLS-1$
        this.mTvExitCode = (TextView)layout.findViewById(R.id.execution_exitcode);
        this.mTvExitCode.setText("-"); //$NON-NLS-1$
        this.mTvOutput = (TextView)layout.findViewById(R.id.execution_output);
        this.mTvOutput.setMovementMethod(new ScrollingMovementMethod());

        // Apply the theme
        applyTheme(context, layout);

        //Create the dialog
        String title = context.getString(R.string.execution_console_title);
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        title,
                                        layout);
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEUTRAL, context.getString(android.R.string.cancel), this);

        // Start the drawing task
        this.mConsoleDrawTask.execute();
    }

