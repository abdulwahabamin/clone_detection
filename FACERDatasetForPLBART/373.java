    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.file_message,null);
        }
        ViewHolder mholder= new ViewHolder();
        mholder.premiereLettre=(TextView)convertView.findViewById(R.id.profilLettre);
        mholder.nom=(TextView)convertView.findViewById(R.id.nom);
        mholder.libele=(TextView)convertView.findViewById(R.id.libele);
        mholder.mac=(TextView)convertView.findViewById(R.id.macadress);

        mholder.premiereLettre.setText(listNom.get(position).substring(0,1));
        mholder.nom.setText(listNom.get(position));
        if(listIntitule.get(position).length()<25){
            mholder.libele.setText(listIntitule.get(position));
        }else{
            mholder.libele.setText(listIntitule.get(position).substring(0,25));
        }
        mholder.mac.setText(macadresse.get(position));

        mholder.mac.setVisibility(View.GONE);

        convertView.setTag(mholder);

        return convertView;
    }

