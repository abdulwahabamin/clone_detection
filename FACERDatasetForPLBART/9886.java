    /**
     * {@inheritDoc}
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.filesystem_info_status:
                //Mount the filesystem
                Switch sw = (Switch)buttonView;
                boolean ret = false;
                try {
                    ret = CommandHelper.remount(
                            this.mContext,
                            this.mMountPoint, isChecked, null);
                    if (ret && !mMountPoint.isSecure()) {
                        Console bgConsole = FileManagerApplication.getBackgroundConsole();
                        if (bgConsole != null) {
                            ret = CommandHelper.remount(
                                    this.mContext,
                                    this.mMountPoint, isChecked, bgConsole);
                        }
                    }

                    //Hide warning message
                    this.mInfoMsgView.setVisibility(View.GONE);
                    //Communicate the mount change
                    if (this.mOnMountListener != null) {
                        this.mOnMountListener.onRemount(this.mMountPoint);
                    }

                } catch (Throwable e) {
                    Log.e(TAG,
                            String.format(
                                    "Fail to remount %s", //$NON-NLS-1$
                                    this.mMountPoint.getMountPoint()), e);
                }
                if (!ret) {
                    //Show warning message
                    this.mInfoMsgView.setText(R.string.filesystem_info_mount_failed_msg);
                    this.mInfoMsgView.setVisibility(View.VISIBLE);
                    sw.setChecked(!isChecked);
                } else if (mMountPoint.isSecure()) {
                    mDialog.dismiss();
                }
                break;

            default:
                break;
        }
    }

