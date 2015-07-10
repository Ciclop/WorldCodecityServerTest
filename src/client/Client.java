package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.terasology.codecity.world.structure.CodeClass;
import org.terasology.codecity.world.structure.CodePackage;
import org.terasology.codecity.world.structure.CodeRepresentation;

public class Client {
    static public void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client simulator");
        CodeRepresentation code = loadCodeRepresentationDefault();
        Socket client = new Socket("localhost", 25778);
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(code);
        out.flush();
        client.close();
        System.out.println("data sended");
    }
    
    private static CodeRepresentation loadCodeRepresentationDefault() {
        CodePackage facet = new CodePackage("facet", "");
        CodePackage generator = new CodePackage("generator", "");
        CodePackage map = new CodePackage("map", "");
        CodePackage structure = new CodePackage("structure", "");
        CodePackage scale = new CodePackage("scale", "");
        CodePackage terasology = new CodePackage("terasology", "");
        
        CodeClass fac = new CodeClass("CodeCityFacet", 1, 18, "");
        facet.addCodeContent(fac);
        
        CodeClass bProv = new CodeClass("", 3, 122, "");
        CodeClass bRast = new CodeClass("", 1, 54, "");
        CodeClass gProv = new CodeClass("", 0, 37, "");
        CodeClass gRast = new CodeClass("", 1, 34, "");
        CodeClass wGen = new CodeClass("", 0, 24, "");
        generator.addCodeContent(bProv);
        generator.addCodeContent(bRast);
        generator.addCodeContent(gProv);
        generator.addCodeContent(gRast);
        generator.addCodeContent(wGen);
        terasology.addCodeContent(generator);
 
        CodeClass cMap = new CodeClass("", 0, 83, "");
        CodeClass cMapF = new CodeClass("", 1,101, "");
        CodeClass cMapH = new CodeClass("", 3,147, "");
        CodeClass cMapN = new CodeClass("", 0,57, "");
        CodeClass cMapC = new CodeClass("", 0,36, "");
        CodeClass cMapCC = new CodeClass("", 1,34, "");
        CodeClass cMapCP = new CodeClass("", 1,43, "");
        CodeClass cMapO = new CodeClass("", 4,67, "");
        map.addCodeContent(cMap);
        map.addCodeContent(cMapF);
        map.addCodeContent(cMapH);
        map.addCodeContent(cMapN);
        map.addCodeContent(cMapC);
        map.addCodeContent(cMapCC);
        map.addCodeContent(cMapCP);
        map.addCodeContent(cMapO);
        terasology.addCodeContent(map);
 
        CodeClass cClas = new CodeClass("", 2, 45, "");
        CodeClass cPac = new CodeClass("", 1,34, "");
        CodeClass cRep = new CodeClass("", 0,17, "");
        structure.addCodeContent(cClas);
        structure.addCodeContent(cPac);
        structure.addCodeContent(cRep);
 
        CodeClass cSca = new CodeClass("", 0,28, "");
        CodeClass cLin = new CodeClass("", 0,16, "");
        CodeClass cSqu = new CodeClass("", 0,21, "");
        scale.addCodeContent(cSca);
        scale.addCodeContent(cLin);
        scale.addCodeContent(cSqu);
        structure.addCodeContent(scale);
        terasology.addCodeContent(structure);
        
        return terasology;
    }
}
