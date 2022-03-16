    private void setCutButtonListener() {

        cut.setOnClickListener((view) -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            options.setImageResource(com.singh.multimeet.quicxplo.R.drawable.cancel1);
            operationFlag=true;
            isCopied = false;
            isMovable = true;
            filesAdapter.disableSelection();
            paste.setVisibility(View.VISIBLE);
            create.setVisibility(View.GONE);
            create_t.setVisibility(View.GONE);
            cut.setVisibility(View.GONE);
            cut_t.setVisibility(View.GONE);
            copy.setVisibility(View.GONE);
            copy_t.setVisibility(View.GONE);
            details.setVisibility(View.GONE);
            details_t.setVisibility(View.GONE);
            rename.setVisibility(View.GONE);
            rename_t.setVisibility(View.GONE);
            delete.setVisibility(View.GONE);
            delete_t.setVisibility(View.GONE);
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

