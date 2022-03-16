    /**
     * Method that shows a message when the operation is complete successfully
     *
     * @param ctx The current context
     * @param res The resource identifier
     * @param dst The destination output
     * @hide
     */
    protected static void showOperationSuccessMsg(Context ctx, int res, String dst) {
        DialogHelper.showToast(ctx, ctx.getString(res, dst), Toast.LENGTH_SHORT);
    }

