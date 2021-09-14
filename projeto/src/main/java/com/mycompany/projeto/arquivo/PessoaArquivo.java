package com.mycompany.projeto.arquivo;
import com.mycompany.projeto.cadastro.CadastroPessoa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PessoaArquivo{
  
  public static void escreverArquivo(CadastroPessoa pessoas){
    File file = new File("PessoaArquivo.bin");
    try{
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(pessoas);


      oos.close();
      fos.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static CadastroPessoa lerArquivo(File file){
    CadastroPessoa pessoas = new CadastroPessoa();

    try{
       FileInputStream fileStream = new FileInputStream(file);    // Creating an object input stream
            try{
                ObjectInputStream objStream = new ObjectInputStream(fileStream);
                try{
                    pessoas = (CadastroPessoa) objStream.readObject();

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