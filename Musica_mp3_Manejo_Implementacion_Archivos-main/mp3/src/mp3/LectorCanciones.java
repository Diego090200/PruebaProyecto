 
package mp3;
import java.io.File;
/**
 *
 * @author alehe
 */
public class LectorCanciones {
    private Pila canciones = new Pila();
    public void listFile(String pathname) {
        File f = new File(pathname);
        File[] listfiles = f.listFiles();
        for (int i = 0; i < listfiles.length; i++) {
            if (listfiles[i].isDirectory()) {
                File[] internalFile = listfiles[i].listFiles();
                for (int j = 0; j < internalFile.length; j++) {
//                    System.out.println(internalFile[j]);
                    if (internalFile[j].getAbsolutePath().endsWith(".mp3") || internalFile[j].getAbsolutePath().endsWith(".MP3"))
                    {
                        canciones.insertar(internalFile[j].getAbsolutePath());
                    }
                    if (internalFile[j].isDirectory()) {
                        String name = internalFile[j].getAbsolutePath();
                        listFile(name);
                    }

                }
            } else {//Para directorio padre y el de arriba para directorio hijo
                String files = listfiles[i].getAbsolutePath();;
                if (files.endsWith(".mp3") || files.endsWith(".MP3"))
                {
                    canciones.insertar(files);
                }
//                System.out.println(listfiles[i]);
            }    
        }
    } 
    public Pila getCanciones() {
        return canciones;
    }
}
