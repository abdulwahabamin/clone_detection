    public void search(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        filteredMusicArrayList.clear();
        if (charText.length() == 0) {
            filteredMusicArrayList.addAll(musicArrayList);
        } else {
            for (Music ep : musicArrayList) {
                if (((!TextUtils.isEmpty(ep.getName())) && (ep.getName()
                        .toLowerCase(Locale.getDefault()).contains(charText)))
                        || ((!TextUtils.isEmpty(ep.getArtistName())) && (ep.getArtistName()
                        .toLowerCase(Locale.getDefault()).contains(charText)))) {
                    filteredMusicArrayList.add(ep);
                }
            }
        }
        notifyDataSetChanged();
    }

