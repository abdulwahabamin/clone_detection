    private void setCopyButtonListener() {
        copy.setOnClickListener((view) -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            options.setImageResource(com.singh.multimeet.quicxplo.R.drawable.cancel1);
            operationFlag=true;
            // filesAdapter.disableSelection();
            isMovable = false;
            isCopied = true;
            filesAdapter.disableSelection();
            delete.setVisibility(View.GONE);
            delete_t.setVisibility(View.GONE);
            paste.setVisibility(View.VISIBLE);
            cut.setVisibility(View.GONE);
            cut_t.setVisibility(View.GONE);
            copy.setVisibility(View.GONE);
            copy_t.setVisibility(View.GONE);
            details.setVisibility(View.GONE);
            details_t.setVisibility(View.GONE);
            rename.setVisibility(View.GONE);
            rename_t.setVisibility(View.GONE);
            create_t.setVisibility(View.GONE);
            create.setVisibility(View.GONE);
            share.setVisibility(view.GONE);
            share_t.setVisibility(View.GONE);
            String dir = fileEx.getCurrentDir();
            if (!dir.contains("emulated")) {
                SOURCE_DESTINATION = FileEx.EXTERNAL;
            }
            createStorageChooser();
            setStorageChooserListener();
        });
    }

