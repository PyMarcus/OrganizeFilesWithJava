package Controller;

import java.io.File;
import java.util.ArrayList;

public class SearchFilesController {
    private String nome_dir;
    private File files;

    public SearchFilesController(String nome_dir){
        this.nome_dir = "/home/marcus/" + nome_dir;
    }
    public SearchFilesController(){
        this.nome_dir = "/home/marcus/Downloads/";
    }

    // setters and getters
    public String getNome_dir(){
        return this.nome_dir;
    }
    public void setNome_dir(String novo_dir){
        this.nome_dir = novo_dir;
    }
    // método da classe
    public ArrayList<String> find_files(){
        files = new File(this.nome_dir);
        ArrayList<String> lista = new ArrayList<String>();
        int contador = 0;
        System.out.println("\nItens encontrados: ");
        for(String arquivos: files.list()){
            contador += 1;
            lista.add(this.nome_dir + arquivos);
            System.out.println(this.nome_dir + arquivos);
        }
        System.out.println("\nTotal de arquivos nesse diretório: " + contador);

        return lista;
    }
}
