package com.proyecto.courierepn;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import BL.Administracion.Perfil;
import UI.Administracion.LoginUI;

public class CourierEPN {

    static Perfil usuario = null;

    public static void main(String[] args) throws Exception {
        FlatMaterialLighterIJTheme.setup();
        new LoginUI().setVisible(true);
    }

}