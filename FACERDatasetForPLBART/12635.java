    /**
     * Constructor of <code>ComputeChecksumDialog</code>.
     *
     * @param context The current context
     * @param fso The file system object to execute
     */
    public ComputeChecksumDialog(final Context context, final FileSystemObject fso) {
        super();

        // Save properties
        this.mContext = context;
        this.mFso = fso;
        this.mHandler = new Handler();
        this.mComputeStatus = 0;

        this.mClipboardMgr =
                (ClipboardManager)this.mContext.getSystemService(Context.CLIPBOARD_SERVICE);

        //Create the layout
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup layout = (ViewGroup)li.inflate(R.layout.compute_checksum_dialog, null);
        TextView tvFileName = (TextView)layout.findViewById(R.id.checksum_filename);
        tvFileName.setText(fso.getFullPath());
        this.mChecksums[0] = (EditText)layout.findViewById(R.id.checksum_md5);
        this.mChecksums[1] = (EditText)layout.findViewById(R.id.checksum_sha1);
        View btMD5 = layout.findViewById(R.id.bt_md5_clipboard);
        btMD5.setOnClickListener(this);
        View btSHA1 = layout.findViewById(R.id.bt_sha1_clipboard);
        btSHA1.setOnClickListener(this);

        // Apply the theme
        applyTheme(context, layout);

        //Create the dialog
        String title = context.getString(R.string.compute_checksum_title);
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        title,
                                        layout);
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEUTRAL, context.getString(android.R.string.ok), this);

        // Start checksum compute
        try {
            this.mCmd = CommandHelper.checksum(context, fso.getFullPath(), this, null);
        } catch (Exception e) {
            ExceptionUtil.translateException(context, e);
        }
    }

