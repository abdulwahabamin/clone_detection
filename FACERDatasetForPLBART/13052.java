                    @Override
                    public void run() {
                        Context ctx = getContext();
                        Log.e(TAG, ctx.getString(
                                R.string.msgs_cant_create_console), e);
                        DialogHelper.showToast(ctx,
                                R.string.msgs_cant_create_console,
                                Toast.LENGTH_LONG);
                        ((Activity)ctx).finish();
                    }

