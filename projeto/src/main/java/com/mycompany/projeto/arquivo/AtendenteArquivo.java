package com.mycompany.projeto.arquivo;
import com.mycompany.projeto.cadastro.CadastroAtendente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AtendenteArquivo{
  
  public static void escreverArquivo(CadastroAtendente pessoas){
    File file = new File("AtendenteArquivo.bin");
    try{
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(pessoas);
            //oos.writeObject(funcionario2);
            //oos.writeObject(funcionario3);

      oos.close();
      fos.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static CadastroAtendente lerArquivo(File file){
    CadastroAtendente pessoas = new CadastroAtendente();

    try{
       FileInputStream fileStream = new FileInputStream(file);    // Creating an object input stream
            try{
                ObjectInputStream objStream = new ObjectInputStream(fileStream);
                try{
                    pessoas = (CadastroAtendente) objStream.readObject();
                    return pessoas;
                }catch(Exception e){
                    e.printStackTrace();
                }
                    
                objStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        
    }
    catch(FileNotFoundException e){

      return pessoas;
    }
    catch(IOException e){
      e.printStackTrace();
    }
    return pessoas;
  }
}