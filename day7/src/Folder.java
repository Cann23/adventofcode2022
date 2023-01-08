import java.awt.*;
import java.util.ArrayList;

public class Folder extends Node{
    private int size;

    private ArrayList<Node> nodes = new ArrayList<>();

    @Override
    public int getSize() {
        for(int i = 0; i < nodes.size(); i++){
            size += nodes.get(i).getSize();
        }
        return size;
    }

    public ArrayList<Folder> getSubFolders(){
        ArrayList<Folder> folders = new ArrayList<>();

        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i) instanceof Folder){
                folders.add((Folder) nodes.get(i));
            }
        }

        return folders;
    }
}
