package com.mycompany.projeto.arquivo;
import com.mycompany.projeto.cadastro.CadastroCliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClienteArquivo{
  
  public static void escreverArquivo(CadastroCliente pessoas){
    File file = new File("ClienteArquivo.bin");
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

  public static CadastroCliente lerArquivo(File file){
    CadastroCliente pessoas = new CadastroCliente();

    try{
       FileInputStream fileStream = new FileInputStream(file);    // Creating an object input stream
            try{
                ObjectInputStream objStream = new ObjectInputStream(fileStream);
                try{
                    pessoas = (CadastroCliente) objStream.readObject();
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