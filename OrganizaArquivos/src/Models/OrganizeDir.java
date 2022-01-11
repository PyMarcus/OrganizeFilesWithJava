package Models;

import Controller.OrganizeDirController;

public class OrganizeDir {
        // classe responsavel por mover os arquivos e criar diretórios
    public static void organize1(){
        try{
            OrganizeDirController.organize();
        }catch (Exception e){
            System.out.println("Houve um erro");
        }
    }
}
