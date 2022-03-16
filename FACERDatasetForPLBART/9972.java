    /**
     * Method that returns a drawable reference of a FileSystemObject.
     *
     * @param iconView View to load the drawable into
     * @param fso The FileSystemObject reference
     * @param defaultIcon Drawable to be used in case no specific one could be found
     * @return Drawable The drawable reference
     */
    public void loadDrawable(ImageView iconView, FileSystemObject fso, Drawable defaultIcon) {
        if (!mUseThumbs) {
            iconView.setImageDrawable(defaultIcon);
            return;
        }

        // Is cached?
        final String filePath = MediaHelper.normalizeMediaPath(fso.getFullPath());
        if (this.mAppIcons.containsKey(filePath)) {
            iconView.setImageDrawable(this.mAppIcons.get(filePath));
            return;
        }

        if (mWorkerThread == null) {
            mWorkerThread = new HandlerThread("IconHolderLoader");
            mWorkerThread.start();
            mWorkerHandler = new WorkerHandler(mWorkerThread.getLooper());
        }
        Loadable previousForView = mRequests.get(iconView);
        if (previousForView != null) {
            mWorkerHandler.removeMessages(MSG_LOAD, previousForView);
        }

        Loadable loadable = new Loadable(mContext, iconView, fso);
        mRequests.put(iconView, loadable);
        iconView.setImageDrawable(defaultIcon);

         mWorkerHandler.obtainMessage(MSG_LOAD, loadable).sendToTarget();
    }

