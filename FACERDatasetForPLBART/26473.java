    public ShareDialog(AppCompatActivity context) {
        mDialog = new Dialog(context, R.style.core_BottomDialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.core_dialog_share, null);
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.core_dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        mDialog.setContentView(dialogView);
        RecyclerView recyclerView =  dialogView.findViewById(R.id.share_list);
        mTitle =  dialogView.findViewById(R.id.share_title);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        mShareAdapter = new BaseRecyclerAdapter(context);
        recyclerView.setAdapter(mShareAdapter);
        mShareAdapter.registerHolder(ShareHolder.class, R.layout.core_item_share);

    }

