package control;

import java.io.File;
import model.Image;
import persistence.FileImageLoader;
import view.MainFrame;

public class Main {

   
    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {
        File file = new File("C:\\Users\\danie\\Documents\\Fotos Ana");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.loadImages();
        new MainFrame().getImageDisplay().show(image);
    }
}
