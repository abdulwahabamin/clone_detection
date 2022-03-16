    private void initBondButton() {
        if (bondState==BOND_BONDED){
            btn.setText("连接");
            bond = false;
        }else {
            btn.setText("�?对");
            bond = true;
        }

    }

