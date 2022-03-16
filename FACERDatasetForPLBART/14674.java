    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_action_bar:
                Intent intent = new Intent();
                intent.setClass(v.getContext(), AudioPlayerHolder.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
                break;
            default:
                break;
        }

    }

