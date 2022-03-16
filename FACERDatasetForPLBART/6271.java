    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        mRoots = DocumentsApplication.getRootsCache(this);

        setResult(Activity.RESULT_CANCELED);
        setContentView(R.layout.activity);

        final Resources res = getResources();
        mShowAsDialog = res.getBoolean(R.bool.show_as_dialog);

        if (mShowAsDialog) {
            // backgroundDimAmount from theme isn't applied; do it manually
            final WindowManager.LayoutParams a = getWindow().getAttributes();
            a.dimAmount = 0.6f;
            getWindow().setAttributes(a);

            getWindow().setFlags(0, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().setFlags(~0, WindowManager.LayoutParams.FLAG_DIM_BEHIND);

            // Inset ourselves to look like a dialog
            final Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);

            final int width = (int) res.getFraction(R.dimen.dialog_width, size.x, size.x);
            final int height = (int) res.getFraction(R.dimen.dialog_height, size.y, size.y);
            final int insetX = (size.x - width) / 2;
            final int insetY = (size.y - height) / 2;

            final Drawable before = getWindow().getDecorView().getBackground();
            final Drawable after = new InsetDrawable(before, insetX, insetY, insetX, insetY);
            getWindow().getDecorView().setBackground(after);

            // Dismiss when touch down in the dimmed inset area
            getWindow().getDecorView().setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        final float x = event.getX();
                        final float y = event.getY();
                        if (x < insetX || x > v.getWidth() - insetX || y < insetY
                                || y > v.getHeight() - insetY) {
                            finish();
                            return true;
                        }
                    }
                    return false;
                }
            });

        } else {
            // Non-dialog means we have a drawer
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                    R.drawable.ic_drawer_glyph, R.string.drawer_open, R.string.drawer_close);

            mDrawerLayout.setDrawerListener(mDrawerListener);
            mDrawerLayout.setDrawerShadow(R.drawable.ic_drawer_shadow, GravityCompat.START);

            mRootsContainer = findViewById(R.id.container_roots);
        }

        mDirectoryContainer = (DirectoryContainerView) findViewById(R.id.container_directory);

        if (icicle != null) {
            mState = icicle.getParcelable(EXTRA_STATE);
        } else {
            buildDefaultState();
        }

        // Hide roots when we're managing a specific root
        if (mState.action == ACTION_MANAGE) {
            if (mShowAsDialog) {
                findViewById(R.id.dialog_roots).setVisibility(View.GONE);
            } else {
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
        }

        if (mState.action == ACTION_CREATE) {
            final String mimeType = getIntent().getType();
            final String title = getIntent().getStringExtra(Intent.EXTRA_TITLE);
            SaveFragment.show(getFragmentManager(), mimeType, title);
        }

        if (mState.action == ACTION_GET_CONTENT) {
            final Intent moreApps = new Intent(getIntent());
            moreApps.setComponent(null);
            moreApps.setPackage(null);
            RootsFragment.show(getFragmentManager(), moreApps);
        } else if (mState.action == ACTION_OPEN || mState.action == ACTION_CREATE
            || mState.action == ACTION_STANDALONE) {
            RootsFragment.show(getFragmentManager(), null);
        }

        if (!mState.restored) {
            if (mState.action == ACTION_MANAGE) {
                final Uri rootUri = getIntent().getData();
                if (rootUri != null) {
                    new RestoreRootTask(rootUri).executeOnExecutor(getCurrentExecutor());
                } else {
                    new RestoreStackTask().execute();
                }
            } else {
                new RestoreStackTask().execute();
            }
        } else {
            onCurrentDirectoryChanged(ANIM_NONE);
        }
    }

