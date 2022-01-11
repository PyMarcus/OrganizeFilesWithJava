package Controller;

import Models.SearchFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OrganizeDirController {
    private static ArrayList<String> capture_ext() {
        SearchFilesController procura_arquivos = new SearchFilesController();
        ArrayList<String> itens = new ArrayList<>();
        ArrayList<String> extensoes = new ArrayList<>();
        File f = new File(procura_arquivos.getNome_dir());
        File verify;
        String nome;
        String ext = "";

        itens = procura_arquivos.find_files();
        System.out.println();
        //criar pastas com base na extensão do arquivo:

        for (int i = 0; i < itens.size(); i++) {
            verify = new File(itens.get(i));
            if (verify.isFile()) {
                nome = itens.get(i);
                int index = nome.lastIndexOf('.');
                if (i > 0) {
                    ext = nome.replaceAll("^.*\\.(.*)$", "$1"); // pega extensão do arquivo
                }
                if (ext.length() < 4) {
                    if (!extensoes.contains(ext)) extensoes.add(ext);
                }
            }
        }

        return extensoes;
    }

    public static void organize() throws IOException {
        ArrayList<String> exts = new ArrayList<>();
        SearchFilesController files = new SearchFilesController();
        File create = new File(files.getNome_dir());
        exts = capture_ext();


        File dir1 = new File(files.getNome_dir() + "Pdfs");
        File verify;
        File dir3 = new File(files.getNome_dir() + "Zips");

        for (String ext : exts) {
            if (dir1.exists()) {
                for (String itens : create.list()) {
                    if (itens.contains(ext)) {
                        if (itens.contains("pdf")) {
                            verify = new File(files.getNome_dir() + itens);
                            boolean ok = verify.renameTo(new File(files.getNome_dir() + "Pdfs/", verify.getName()));
                            if (ok) System.out.println(itens + " movido");
                            else System.out.println(itens + " não movido");
                        }
                    }
                }
            } else {
                System.out.println("Diretório não existente...Criando...");
                Files.createDirectory(Paths.get(files.getNome_dir() + "Pdfs"));
                for (String itens : create.list()) {
                    if (itens.contains(ext)) {
                        if (itens.contains("pdf")) {
                            verify = new File(files.getNome_dir() + itens);
                            boolean ok = verify.renameTo(new File(files.getNome_dir() + "Pdfs/", verify.getName()));
                            if (ok) System.out.println(itens + " movido");
                            else System.out.println(itens + " não movido");
                        }
                    }
                }

            }
            if (dir3.exists()) {
                for (String itens : create.list()) {
                    if (itens.contains(ext)) {
                        if (itens.contains("zip")) {
                            verify = new File(files.getNome_dir() + itens);
                            boolean ok = verify.renameTo(new File(files.getNome_dir() + "Zips/", verify.getName()));
                            if (ok) System.out.println(itens + " movido");
                            else System.out.println(itens + " não movido");
                        }
                    }
                }
            } else {
                System.out.println("Diretório não existente...Criando...");
                Files.createDirectory(Paths.get(files.getNome_dir() + "Zips"));
                for (String itens : create.list()) {
                    if (itens.contains(ext)) {
                        if (itens.contains("zip")) {
                            verify = new File(files.getNome_dir() + itens);
                            boolean ok = verify.renameTo(new File(files.getNome_dir() + "Zips/", verify.getName()));
                            if (ok) System.out.println(itens + " movido");
                            else System.out.println(itens + " não movido");
                        }
                    }
                }

            }

        }
        System.out.println("\nTudo em ordem.");
    }
}
